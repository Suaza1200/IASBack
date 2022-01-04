package com.example.demo.controllers;


import com.example.demo.domain.*;
import com.example.demo.model.CreateProductInput;
import com.example.demo.model.CreateProductOutput;
import com.example.demo.model.UpdateProductInput;
import com.example.demo.model.UpdateProductOutput;
import com.example.demo.services.ProductServices;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    private final ProductServices services;

    public ProductController(ProductServices services) {
        this.services = services;
    }

    @GetMapping
    public List<Product> listProduct() {
        return services.listProduct();
    }

    @PostMapping
    public CreateProductOutput createProduct(@RequestBody CreateProductInput input) {
        ProductName productName = new ProductName(input.getName());
        BigDecimal price = input.getPrice();
        ProductId random = ProductId.random();
        ProductDescription description = new ProductDescription(input.getDescription());
        ProductQuantity quantity = new ProductQuantity(input.getQuantity());
        Product product = new Product(random, productName, price, description, quantity);
        Product createdProduct = services.createProduct(product);

        return new CreateProductOutput(createdProduct);
    }


    @GetMapping(value = "/{id}")
    public Product getProduct(@PathVariable("id") String productId) {
        final ProductId id = ProductId.fromString(productId);
        return services.getProduct(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProduct(@PathVariable("id") String productId) {
        final ProductId id = ProductId.fromString(productId);
        services.deleteProduct(productId);
    }

    @PutMapping(value = "/{id}")
    public UpdateProductOutput updateProduct(@PathVariable("id") String unsafeId, @RequestBody UpdateProductInput input) {
        final ProductId id = ProductId.fromString(unsafeId);
        Product newProduct = new Product(id, new ProductName(input.getName()), input.getPrice(), new ProductDescription(input.getDescription()),new ProductQuantity(input.getQuantity()));
        final Product updated = services.updateProduct(id, newProduct);
        return new UpdateProductOutput(updated);
    }
}
