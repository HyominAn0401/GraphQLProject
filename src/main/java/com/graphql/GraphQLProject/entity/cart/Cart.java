package com.graphql.GraphQLProject.entity.cart;

import com.graphql.GraphQLProject.entity.user.User;
import lombok.Setter;

import java.util.List;

public class Cart {
    private final String id;
    private final User user;
    @Setter
    private double totalAmount = 0.0;
    @Setter
    private List<CartItem> items = List.of();

    public Cart(String id, User user) {
        this.id = id;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public List<CartItem> getItems() {
        return items;
    }

}
