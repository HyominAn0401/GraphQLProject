package com.graphql.GraphQLProject.entity.cart;

import com.graphql.GraphQLProject.entity.product.Product;

public class CartItem {
    private final String id;
    private final int quantity;
    private final Product product;
    private final Cart cart;

    public CartItem(String id, int quantity, Product product, Cart cart) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
        this.cart = cart;
    }
    public String getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public Cart getCart() {
        return cart;
    }
}
