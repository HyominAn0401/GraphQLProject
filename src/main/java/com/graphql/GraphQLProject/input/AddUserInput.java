package com.graphql.GraphQLProject.input;

import lombok.*;

import java.beans.ConstructorProperties;

public class AddUserInput {
    private final String name;
    private final String email;

    @ConstructorProperties({"name", "email"})
    public AddUserInput(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

}
