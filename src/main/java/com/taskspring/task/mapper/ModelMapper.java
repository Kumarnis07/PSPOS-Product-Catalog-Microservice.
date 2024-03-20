package com.taskspring.task.mapper;

import com.taskspring.task.model.Product;
import com.taskspring.task.model.solr.IndexedProduct;
import org.apache.spark.sql.Row;

public interface ModelMapper {
    Product rowToModelMapper(Row row);
    IndexedProduct productToIndexedProductMapper(Product product);
}
