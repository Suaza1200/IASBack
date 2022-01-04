package com.example.demo.domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class ProductDescription {
    private static final Pattern pattern = Pattern.compile("^[a-zA-Z\\s:]{10,300}$");

    private final String value;

    public ProductDescription(String value) {
        Objects.requireNonNull(value, "Product description can not be null");
        String trimmedValue = value.trim();
        if(trimmedValue.length()  == 0) {
            throw new IllegalArgumentException("Product description  can not be empty");
        }

        boolean isValid = pattern.matcher(trimmedValue).matches();
        if(!isValid) {
            throw new IllegalArgumentException("Invalid product description ");
        }

        this.value = trimmedValue;
    }

    @Override
    public String toString() {
        return value;
    }
}
