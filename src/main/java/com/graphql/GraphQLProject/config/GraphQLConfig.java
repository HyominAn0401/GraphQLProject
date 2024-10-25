package com.graphql.GraphQLProject.config;

import graphql.scalars.ExtendedScalars;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
// Extended Scalars에서 지원하는 여러 스칼라 타입을 GraphQL Schema에 추가하는 역할
// 스키마에서 DateTime Scalar 사용 가능
public class GraphQLConfig {
    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return wiringBuilder -> wiringBuilder.scalar(ExtendedScalars.DateTime);
    }
}
