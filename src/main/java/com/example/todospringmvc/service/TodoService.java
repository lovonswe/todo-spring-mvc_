package com.example.todospringmvc.service;

import com.example.todospringmvc.dto.TodoDto;
import com.example.todospringmvc.model.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TodoService  {
    public List<Todo> findAllTodo();
    public Todo createTodo(TodoDto todoDto);
}
