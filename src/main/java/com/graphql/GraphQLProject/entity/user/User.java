package com.graphql.GraphQLProject.entity.user;

import com.graphql.GraphQLProject.entity.SearchResult;
import com.graphql.GraphQLProject.entity.cart.Cart;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

public class User implements SearchResult {
    private final String id;
    private final String name;
    private final String email;
    private final OffsetDateTime createdAt;
    @Setter
    private Cart cart;

    public User(String id, String name, String email, OffsetDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
        this.cart = null;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public Cart getCart() {
        return cart;
    }

}