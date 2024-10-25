package com.graphql.GraphQLProject.resolver;

import com.graphql.GraphQLProject.entity.product.Product;
import com.graphql.GraphQLProject.input.AddProductInput;
import com.graphql.GraphQLProject.service.ProductService;
import org.apache.coyote.BadRequestException;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.util.List;

@Controller
public class ProductResolver {
    private final ProductService productService;

    public ProductResolver(ProductService productService) {
        this.productService = productService;
    }

    @QueryMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @MutationMapping
    public Product addProduct(@Argument("addProductInput") AddProductInput addProductInput) throws BadRequestException {
        return productService.addProduct(addProductInput);
    }

    @SubscriptionMapping
    public Flux<Product> newProduct(@Argument("productName") String productName) {
        return productService.messageFlux(productName);
    }
}
