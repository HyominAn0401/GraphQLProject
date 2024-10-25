package com.graphql.GraphQLProject.resolver;

import com.graphql.GraphQLProject.entity.user.User;
import com.graphql.GraphQLProject.input.AddUserInput;
import com.graphql.GraphQLProject.service.UserService;
import org.apache.coyote.BadRequestException;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class UserResolver {
    private final UserService userService;

    public UserResolver(UserService userService) {
        this.userService = userService;
    }

    @QueryMapping
    public User getUser(@Argument("userId") String userId) throws BadRequestException {
        return userService.getUser(userId);
    }

    @MutationMapping
    public User addUser(@Argument("addUserInput") AddUserInput addUserInput) {
        return userService.addUser(addUserInput);
    }
}