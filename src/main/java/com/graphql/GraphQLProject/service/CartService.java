package com.graphql.GraphQLProject.service;

import com.graphql.GraphQLProject.entity.cart.Cart;
import com.graphql.GraphQLProject.entity.cart.CartItem;
import com.graphql.GraphQLProject.entity.user.User;
import com.graphql.GraphQLProject.input.AddCartItemInput;
import com.graphql.GraphQLProject.input.DeleteCartItemInput;
import com.graphql.GraphQLProject.repository.Database;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CartService {
    private final ProductService productService;

    public CartService(ProductService productService) {
        this.productService = productService;
    }

    public Cart getUserCart(String userId) throws BadRequestException {
        return Database.getInstance().carts.stream()
                .filter(cart -> cart.getUser().getId().equals(userId))
                .findFirst()
                .map(cart -> {
                    cart.setItems(Database.getInstance().cartItems.stream()
                            .filter(cartItem -> cartItem.getCart().getId().equals(cart.getId()))
                            .toList());
                    cart.setTotalAmount(cart.getItems().stream()
                            .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                            .sum());
                    return cart;
                })
                .orElseThrow(() -> new BadRequestException("Cart not found"));
    }

    public Cart addUserCart(User user) {
        Cart cart = new Cart(
                UUID.randomUUID().toString().substring(0, 5),
                user
        );
        Database.getInstance().carts.add(cart);
        return cart;
    }

    public Cart addCartItem(AddCartItemInput addCartItemInput) throws BadRequestException {
        CartItem cartItem = new CartItem(
                UUID.randomUUID().toString().substring(0, 5),
                addCartItemInput.getQuantity(),
                productService.getProduct(addCartItemInput.getProductId()),
                getUserCart(addCartItemInput.getUserId())
        );
        Database.getInstance().cartItems.add(cartItem);
        return getUserCart(addCartItemInput.getUserId());
    }

    public Cart deleteCartItem(DeleteCartItemInput deleteCartItemInput) throws BadRequestException {
        Database.getInstance().cartItems.removeIf(cartItem -> cartItem.getId().equals(deleteCartItemInput.getCartItemId()));
        return getUserCart(deleteCartItemInput.getUserId());
    }
}
