package com.example.demo.model;


import com.example.demo.domain.Product;

public class UpdateProductOutput {
    private Product product;

    public UpdateProductOutput() {
    }

    public UpdateProductOutput(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setPerson(Product product) {
        this.product = product;
    }
}
