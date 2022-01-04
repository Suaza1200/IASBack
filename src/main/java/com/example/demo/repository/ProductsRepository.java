package com.example.demo.repository;

import com.example.demo.domain.ProductId;
import com.example.demo.domain.Product;

import java.util.List;

public interface ProductsRepository {
    List<Product> list();

    Product findOne(ProductId id);

    void create(Product product);

    void update(ProductId id, Product product);

    void delete(String id);
}
