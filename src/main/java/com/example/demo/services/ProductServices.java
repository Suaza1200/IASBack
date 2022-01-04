package com.example.demo.services;

import com.example.demo.domain.Product;
import com.example.demo.domain.ProductId;

import com.example.demo.repository.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {


    private ProductsRepository repository;

    public ProductServices(ProductsRepository repository) {
        this.repository = repository;
    }


    public List<Product> listProduct() {
        return repository.list();
    }


    public Product createProduct(Product product) {
        repository.create(product);
        return product;
    }


    public Product getProduct(ProductId productId) {
        return repository.findOne(productId);
    }


    public void deleteProduct(String productId) {
        repository.delete(productId);
    }


    public Product updateProduct(ProductId productId, Product product) {
        repository.update(productId, product);

        return repository.findOne(productId);
    }

}
