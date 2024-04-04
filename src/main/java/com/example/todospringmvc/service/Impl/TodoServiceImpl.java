package com.example.todospringmvc.service.Impl;

import com.example.todospringmvc.dto.TodoDto;
import com.example.todospringmvc.model.Todo;
import com.example.todospringmvc.service.TodoService;

import java.util.List;

public class TodoServiceImpl implements TodoService {
    @Override
    public List<Todo> findAllTodo() {
        return null;
    }

    @Override
    public Todo createTodo(TodoDto todoDto) {
        Todo newTodo = new Todo();

        return null;
    }
}
