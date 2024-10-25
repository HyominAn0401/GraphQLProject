package com.graphql.GraphQLProject.entity.product;

import com.graphql.GraphQLProject.entity.SearchResult;

public interface Product extends SearchResult {
    String getId();
    String getName();
    double getPrice();
    ProductType getProductType();
}