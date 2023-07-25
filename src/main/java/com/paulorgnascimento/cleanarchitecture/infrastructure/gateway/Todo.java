package com.paulorgnascimento.cleanarchitecture.infrastructure.gateway;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Todo {
    private int userId;
    private int id;
    private String title;
    private boolean completed;
}
