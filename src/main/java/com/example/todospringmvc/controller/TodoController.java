package com.example.todospringmvc.controller;

import com.example.todospringmvc.dto.TodoDto;
import com.example.todospringmvc.exception.RequestBodyEmptyException;
import com.example.todospringmvc.model.Todo;
import com.example.todospringmvc.service.Impl.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoServiceImpl todoService;

    @GetMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("name", "Nahid");
        return "components/TodoList";
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
//
//    }

    @PostMapping
    public ResponseEntity<?> addNewTodo(@RequestBody TodoDto todoDto) throws RequestBodyEmptyException {
        System.out.println("Controller");
        Todo todo = todoService.saveTodo(todoDto);
        return new ResponseEntity<>(todo, HttpStatus.CREATED);
    }
}
