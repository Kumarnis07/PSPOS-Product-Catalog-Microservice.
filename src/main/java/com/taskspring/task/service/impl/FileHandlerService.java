package com.taskspring.task.service.impl;

import com.taskspring.task.mapper.ModelMapper;
import com.taskspring.task.model.Product;
import com.taskspring.task.model.request.ProductDto;
import com.taskspring.task.model.response.Response;
import com.taskspring.task.model.solr.IndexedProduct;
import com.taskspring.task.repository.ProductRepository;
import com.taskspring.task.service.IFileHanlderService;
import com.taskspring.task.util.QueryGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FileHandlerService implements IFileHanlderService {
    private final ProductRepository productRepository;
    private final SolrClient solrClient;
    private final SparkSession sparkSession;
    private final ModelMapper modelMapper;
    @Value("${batch.size}")
    private Integer BATCH_SIZE;
    private static final String UPLOAD_DIR = "src/main/resources";


    public Response persistAndIndex(String file) throws SolrServerException, IOException {
        Dataset<Row> dataset = generateDataset(file);
        List<Product> products = new ArrayList<>();
        List<IndexedProduct> solrIndexedProducts = new ArrayList<>();
        for (Row row : dataset.collectAsList()) {
            Product product = modelMapper.rowToModelMapper(row);
            products.add(product);
            solrIndexedProducts.add(modelMapper.productToIndexedProductMapper(product));
            if (products.size() >= BATCH_SIZE) {
                productRepository.saveAll(products);
                products.clear();
            }
        }
        if (products.size() > 0) {
            productRepository.saveAll(products);
        }
        log.info("Data has been persisted.");
        solrClient.addBeans(solrIndexedProducts);
        solrClient.commit();
        log.info("Data has been indexed");
        return Response.builder().message("Data has been persisted and indexed successfully!").build();
    }
    public Response processFile(String fileName, MultipartFile file){
        try {
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            Files.copy(file.getInputStream(), uploadPath.resolve(file.getOriginalFilename()));
            File targetFile = new File("src/main/resources/" + fileName);
            persistAndIndex(targetFile.getPath());
            if (targetFile.exists()) {
                targetFile.delete();
            }
            return Response.builder().message("Data has been persisted and indexed.").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.builder().message("Something went wrong.").build();
        }
    }
    public Dataset<Row> generateDataset(String filePath){
        return sparkSession.read()
                .option("delimiter", filePath.endsWith(".tsv") ? "\t" : ",")
                .option("header", true)
                .option("inferSchema", true)
                .csv(filePath);
    }

    public SolrDocumentList search(ProductDto productDto) throws SolrServerException, IOException {
        SolrQuery searchQuery = new SolrQuery();
        QueryGenerator queryGenerator = new QueryGenerator();
        String query = queryGenerator.createSearchQuery(productDto);
        if (!query.isEmpty()) {
            searchQuery.set("q", query);
        } else {
            searchQuery.set("q", "*:*");
        }
        QueryResponse response = solrClient.query(searchQuery);
        log.info("Search query : {}", query);
        return response.getResults();
    }
}
