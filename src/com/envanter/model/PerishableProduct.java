package com.envanter.model;

import java.time.LocalDate;

public class PerishableProduct extends Product {

    private LocalDate expiryDate;

    public PerishableProduct(int id, String name, double price, int stockQuantity, LocalDate expiryDate) {
        super(id, name, price, stockQuantity);
        this.expiryDate = expiryDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }
}
