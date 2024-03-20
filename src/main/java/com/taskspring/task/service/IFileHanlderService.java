package com.taskspring.task.service;

import com.taskspring.task.model.request.ProductDto;
import com.taskspring.task.model.response.Response;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IFileHanlderService {
    Response persistAndIndex(String file) throws SolrServerException, IOException;
    SolrDocumentList search(ProductDto productDto) throws SolrServerException, IOException;
    Response processFile(String fileName, MultipartFile file);
}
