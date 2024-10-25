package com.graphql.GraphQLProject.entity.product;

import lombok.Getter;

public class Electronics implements Product {
    private final String id;
    private final String name;
    private final double price;
    @Getter
    private final String warrantyPeriod;
    private final ProductType productType = ProductType.ELECTRONICS;

    public Electronics(String id, String name, double price, String warrantyPeriod) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.warrantyPeriod = warrantyPeriod;
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
