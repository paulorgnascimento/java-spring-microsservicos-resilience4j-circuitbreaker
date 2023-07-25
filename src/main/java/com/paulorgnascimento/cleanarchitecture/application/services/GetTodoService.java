package com.paulorgnascimento.cleanarchitecture.application.services;

import com.paulorgnascimento.cleanarchitecture.infrastructure.gateway.Todo;
import com.paulorgnascimento.cleanarchitecture.infrastructure.gateway.TodoGateway;
import org.springframework.stereotype.Service;

@Service
public class GetTodoService {

    private TodoGateway todoGateway;

    public GetTodoService(TodoGateway todoGateway) {
        this.todoGateway = todoGateway;
    }

    public Todo execute(int id) {
        return todoGateway.getTodoById(id);
    }
}