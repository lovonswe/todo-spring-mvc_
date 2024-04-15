package com.example.todospringmvc.service;

import com.example.todospringmvc.dto.TodoDto;
import com.example.todospringmvc.exception.RequestBodyEmptyException;
import com.example.todospringmvc.exception.TodoNotFoundException;
import com.example.todospringmvc.model.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TodoService  {
    public List<Todo> findAllTodo();
    public Todo saveTodo(TodoDto todoDto) throws RequestBodyEmptyException;
    public Todo getTodoById(Long id) throws TodoNotFoundException;
}
