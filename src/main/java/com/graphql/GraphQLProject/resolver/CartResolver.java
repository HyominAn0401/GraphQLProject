package com.graphql.GraphQLProject.resolver;

import com.graphql.GraphQLProject.entity.cart.Cart;
import com.graphql.GraphQLProject.input.AddCartItemInput;
import com.graphql.GraphQLProject.input.DeleteCartItemInput;
import com.graphql.GraphQLProject.service.CartService;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CartResolver {
    private final CartService cartService;

    public CartResolver(CartService cartService) {
        this.cartService = cartService;
    }

    @QueryMapping
    public Cart getUserCart(@Argument("userId") String userId) throws BadRequestException {
        return cartService.getUserCart(userId);
    }

    @MutationMapping
    public Cart addCartItem(@Argument("addCartItemInput") AddCartItemInput addCartItemInput) throws BadRequestException {
        return cartService.addCartItem(addCartItemInput);
    }

    @MutationMapping
    public Cart deleteCartItem(@Argument("deleteCartItemInput") DeleteCartItemInput deleteCartItemInput) throws BadRequestException {
        return cartService.deleteCartItem(deleteCartItemInput);
    }
}
