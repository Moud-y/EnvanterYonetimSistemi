package com.envanter.model;

public class Product implements Storable {

    private int id;
    private String name;
    private double price;
    private int stockQuantity;

    public Product(int id, String name, double price, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    // Getters & Setters (Encapsulation)
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    // Interface methods
    @Override
    public void store() {
        // implementation later
    }

    @Override
    public void remove() {
        // implementation later
    }
}

//Day 2: OOP class structure 

