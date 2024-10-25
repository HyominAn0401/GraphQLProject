package com.graphql.GraphQLProject.input;

public class DeleteCartItemInput {
    private final String cartItemId;
    private final String userId;

    public DeleteCartItemInput(String cartItemId, String userId) {
        this.cartItemId = cartItemId;
        this.userId = userId;
    }

    public String getCartItemId() {
        return cartItemId;
    }

    public String getUserId() {
        return userId;
    }
}
