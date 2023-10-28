package org.example.rulebased.cachepattern.ruleunit;


public class Product {
    
    public String productId;

    public String name;

    public int price;

    public Product(String productId, String name, int price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public Product() {
    }
}
