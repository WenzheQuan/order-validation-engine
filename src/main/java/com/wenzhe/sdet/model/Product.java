package com.wenzhe.sdet.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private final String id;
    private final String name;
    private final BigDecimal price;
    private final int stockQuantity;

    public Product(String id, String name, BigDecimal price, int stockQuantity) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Product id cannot be empty");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Product name cannot be empty");
        }

        if (price == null || price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Product price cannot be negative");
        }

        if (stockQuantity < 0) {
            throw new IllegalArgumentException("Stock quantity cannot be negative");
        }

        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public boolean hasEnoughStock(int requestedQuantity) {
        return requestedQuantity > 0 && requestedQuantity <= stockQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Product product)) {
            return false;
        }

        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
