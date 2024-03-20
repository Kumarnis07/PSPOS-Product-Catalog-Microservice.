package com.taskspring.task.controller;

import com.taskspring.task.model.request.ProductDto;
import com.taskspring.task.model.response.Response;
import com.taskspring.task.service.impl.FileHandlerService;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileHandlerController {
    @Autowired
    private FileHandlerService fileHandlerService;


    @PostMapping("/upload")
    public ResponseEntity<Response> uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body(Response.builder().message("File is empty!").build());
        }
        String fileName = file.getOriginalFilename();
        if (fileName != null && !fileName.endsWith(".csv") && !fileName.endsWith(".tsv")) {
            return ResponseEntity.badRequest().body(Response.builder().message("Invalid file type!").build());
        }
        return ResponseEntity.ok(fileHandlerService.processFile(fileName, file));

    }

    @GetMapping("/search")
    public ResponseEntity<SolrDocumentList> get(@RequestBody ProductDto productDto) throws SolrServerException, IOException {
        return ResponseEntity.ok(fileHandlerService.search(productDto));
    }
}
