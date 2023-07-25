package com.paulorgnascimento.cleanarchitecture.infrastructure.gateway;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class TodoWebClientGateway implements TodoGateway {

    private final WebClient webClient;

    public TodoWebClientGateway(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://jsonplaceholder.typicode.com").build();
    }

    @Override
    public Todo getTodoById(int id) {
        return webClient.get()
                .uri("/todos/" + id)
                .retrieve()
                .bodyToMono(Todo.class)
                .block(); // You should avoid using block in a reactive programming, this is for the sake of simplicity
    }
}