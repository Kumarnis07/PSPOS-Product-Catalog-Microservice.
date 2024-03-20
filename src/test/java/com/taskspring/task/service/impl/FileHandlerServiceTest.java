package com.taskspring.task.service.impl;

import com.taskspring.task.mapper.ModelMapper;
import com.taskspring.task.model.Product;
import com.taskspring.task.model.request.ProductDto;
import com.taskspring.task.model.response.Response;
import com.taskspring.task.model.solr.IndexedProduct;
import com.taskspring.task.repository.ProductRepository;
import com.taskspring.task.util.QueryGenerator;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyList;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class FileHandlerServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private SolrClient solrClient;

    @Mock
    private SparkSession sparkSession;

    @Mock
    private ModelMapper modelMapper;
    @Mock
    private QueryResponse queryResponse;

    @InjectMocks
    private FileHandlerService fileHandlerService;

    private static final int BATCH_SIZE = 5000;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void persistAndIndex_Success() throws SolrServerException, IOException {
        // Mock data
        Dataset<Row> dataset = mock(Dataset.class);
        Row row1 = mock(Row.class);
        Row row2 = mock(Row.class);
        when(dataset.collectAsList()).thenReturn(List.of(row1, row2));

        // Mock SparkSession behavior to directly return the mock dataset
        when(sparkSession.read().option(anyString(), anyString()).option(anyString(), anyBoolean()).option(anyString(), anyBoolean()).csv(anyString())).thenReturn(dataset);

        // Mock mappings
        Product product = new Product(); // Mock product
        IndexedProduct indexedProduct = new IndexedProduct(); // Mock indexed product
        when(modelMapper.rowToModelMapper(any(Row.class))).thenReturn(product);
        when(modelMapper.productToIndexedProductMapper(any(Product.class))).thenReturn(indexedProduct);

        // Call the method
        Response response = fileHandlerService.persistAndIndex("test.csv");

        // Verify interactions
        verify(productRepository, times(1)).saveAll(anyList());
        verify(solrClient, times(1)).addBeans(anyList());
        verify(solrClient, times(1)).commit();
        // Assert the response
        assertNotNull(response);
        assertEquals("Data has been persisted and indexed successfully!", response.getMessage());
    }

    @Test
    void testSearch() throws IOException, SolrServerException {
        // Mock data
        ProductDto productDto = new ProductDto();
        productDto.setId(123);
        // Mock QueryGenerator behavior
        String expectedQuery = "*:*";
        QueryGenerator queryGenerator = new QueryGenerator();
        when(queryGenerator.createSearchQuery(productDto)).thenReturn(expectedQuery);

        // Mock QueryResponse and SolrDocumentList
        SolrDocumentList solrDocumentList = mock(SolrDocumentList.class);
        when(queryResponse.getResults()).thenReturn(solrDocumentList);
        when(solrClient.query(any())).thenReturn(queryResponse);

        // Call the method
        SolrDocumentList result = fileHandlerService.search(productDto);

        // Verify interactions
        verify(solrClient).query(any());
        // Assert the result
        assertEquals(solrDocumentList, result);
    }
}
