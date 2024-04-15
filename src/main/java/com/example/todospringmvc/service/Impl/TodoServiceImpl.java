package com.example.todospringmvc.service.Impl;

import com.example.todospringmvc.dto.TodoDto;
import com.example.todospringmvc.exception.RequestBodyEmptyException;
import com.example.todospringmvc.exception.TodoNotFoundException;
import com.example.todospringmvc.model.Todo;
import com.example.todospringmvc.repository.TodoRepository;
import com.example.todospringmvc.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Todo getTodoById(Long id) throws TodoNotFoundException {
        Optional<Todo> todo = todoRepository.findById(id);
        if(todo.isEmpty()) {
            throw new TodoNotFoundException("Todo not found with id " + id);
        }
        return todo.get();
    }

    @Override
    public Todo updateTodo(Todo todo) throws TodoNotFoundException {
        Long id = todo.getId();
        Todo todoToUpdate = getTodoById(id);
        Todo updatedTodo = mapTodo(todo, todoToUpdate);
        return todoRepository.save(updatedTodo);
    }

    @Override
    public List<Todo> getAllTodos() throws TodoNotFoundException {
        List<Todo> todos = todoRepository.findAll();
        if(todos.isEmpty()){
            throw new TodoNotFoundException("Todo list is empty.");
        }
        return todos;
    }

    public Todo mapTodo (Todo newTodo, Todo currentTodo) {
        if(currentTodo.getTitle() != null)
        currentTodo.setTitle(newTodo.getTitle());
        if(currentTodo.getDescription() != null)
            currentTodo.setDescription(newTodo.getDescription());
        currentTodo.setStar(newTodo.getStar());
        if(currentTodo.getPriority() != null)
            currentTodo.setPriority(newTodo.getPriority());
        if(currentTodo.getStatus() != null)
            currentTodo.setStatus(newTodo.getStatus());
        if(currentTodo.getDateTime() != null)
            currentTodo.setDateTime(newTodo.getDateTime());
        return currentTodo;
    }
}
