package com.example.demo.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private final ProductId id;
    private final ProductName name;
    private final BigDecimal price;
    private  final ProductDescription description;
    private final ProductQuantity quantity;

    public Product(ProductId id, ProductName name, BigDecimal price, ProductDescription description, ProductQuantity quantity) {
        Objects.requireNonNull(id, "Product id can not be null");
        Objects.requireNonNull(name, "Product name can not be null");
        Objects.requireNonNull(price, "Product price can not be null");
        Objects.requireNonNull(description, "Product description can not be null");
        Objects.requireNonNull(quantity, "Product quantity can not be null");

        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    public ProductId getId() {
        return id;
    }

    public ProductName getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductDescription getDescription(){ return description;}

    public  ProductQuantity getQuantity(){ return  quantity;}

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name=" + name +
                ", price=" + price +
                ", description=" + description +
                ", quantity=" + quantity +
                '}';
    }
}
