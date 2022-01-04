package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CreateProductInput {
    private String name;
    private BigDecimal price;
    private String description;


    private int quantity;

    public CreateProductInput() {
    }

    public CreateProductInput(String name, BigDecimal price, String description, int quantity) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
