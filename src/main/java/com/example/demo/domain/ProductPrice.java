package com.example.demo.domain;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.regex.Pattern;

public class ProductPrice {
    private static final Pattern pattern = Pattern.compile("^{1,64}$");

    private final BigDecimal value;

    public ProductPrice(String value) {
        Objects.requireNonNull(value, "Product price can not be null");
        String trimmedValue = value.trim();
        if(trimmedValue.length()  == 0) {
            throw new IllegalArgumentException("Product price can not be empty");
        }

       BigDecimal finalPrice = new BigDecimal(trimmedValue);

        this.value = finalPrice;
    }
}
