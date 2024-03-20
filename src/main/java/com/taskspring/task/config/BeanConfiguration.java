package com.taskspring.task.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.BinaryRequestWriter;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

@Configuration
public class BeanConfiguration {
    @Value("${solr.client.url}")
    private String solrUrl;

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation("classpath:main/resources");
        factory.setMaxFileSize(DataSize.parse("100MB"));
        factory.setMaxRequestSize(DataSize.parse("150MB"));
        return factory.createMultipartConfig();
    }

    @Bean
    public SolrClient solrClient() {
        HttpSolrClient solrClient = new HttpSolrClient.Builder(solrUrl).build();
        solrClient.setRequestWriter(new BinaryRequestWriter());
        return solrClient;
    }

    @Bean
    public SparkSession sparkSession(){
        return SparkSession.builder().appName("spark-java-example")
                .master("local")
                .getOrCreate();
    }

}
