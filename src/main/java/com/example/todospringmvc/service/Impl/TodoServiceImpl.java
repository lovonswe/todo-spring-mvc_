package com.example.todospringmvc.service.Impl;

import com.example.todospringmvc.dto.TodoDto;
import com.example.todospringmvc.exception.RequestBodyEmptyException;
import com.example.todospringmvc.model.Todo;
import com.example.todospringmvc.repository.TodoRepository;
import com.example.todospringmvc.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<Todo> findAllTodo() {
        return null;
    }

    @Override
    public Todo saveTodo(TodoDto todoDto) throws RequestBodyEmptyException {
        if(todoDto == null){
            System.out.println("service");
            throw new RequestBodyEmptyException("Request body is empty");
        }

        Todo newTodo = Todo.build(
                0L,
                todoDto.getTitle(),
                todoDto.getDescription(),
                todoDto.getDateTime(),
                todoDto.getStar(),
                todoDto.getPriority(),
                todoDto.getStatus()
        );
        return todoRepository.save(newTodo);
    }
}
