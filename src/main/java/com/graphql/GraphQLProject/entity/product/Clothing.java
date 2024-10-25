package com.graphql.GraphQLProject.entity.product;

import lombok.Getter;

public class Clothing implements Product {
    private final String id;
    private final String name;
    private final double price;
    @Getter
    private final String size;
    private final ProductType productType = ProductType.CLOTHING;

    public Clothing(String id, String name, double price, String size) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.size = size;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public ProductType getProductType() {
        return productType;
    }
}