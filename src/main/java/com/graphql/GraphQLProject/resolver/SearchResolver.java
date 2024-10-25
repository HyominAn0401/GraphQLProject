package com.graphql.GraphQLProject.resolver;

import com.graphql.GraphQLProject.entity.SearchResult;
import com.graphql.GraphQLProject.service.ProductService;
import com.graphql.GraphQLProject.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchResolver {
    private final ProductService productService;
    private final UserService userService;

    public SearchResolver(ProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    @QueryMapping
    public List<SearchResult> search(@Argument("keyword") String keyword) {
        List<SearchResult> results = new ArrayList<>();
        results.addAll(productService.getProducts().stream()
                .filter(product -> product.getName().contains(keyword))
                .toList());
        results.addAll(userService.getUsers().stream()
                .filter(user -> user.getName().contains(keyword))
                .toList());
        return results;
    }
}
