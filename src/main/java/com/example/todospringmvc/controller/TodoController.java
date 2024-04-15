package com.example.todospringmvc.controller;

import com.example.todospringmvc.dto.TodoDto;
import com.example.todospringmvc.exception.RequestBodyEmptyException;
import com.example.todospringmvc.exception.TodoNotFoundException;
import com.example.todospringmvc.model.Todo;
import com.example.todospringmvc.service.Impl.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoServiceImpl todoService;

    @GetMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("name", "Nahid");
        return "components/welcome"; // Assuming you have a view named welcome.html or welcome.jsp
    }

    @GetMapping("/{id}")
    public String getTodoById(@PathVariable Long id, Model model) throws TodoNotFoundException {
        Todo todo = todoService.getTodoById(id);
        model.addAttribute("todo", todo);
        return "components/todo-details"; // Assuming you have a view named todo-details.html or todo-details.jsp
    }

    @GetMapping
    public String getAllTodos(Model model) throws TodoNotFoundException {
        List<Todo> todos = todoService.getAllTodos();
        model.addAttribute("todos", todos);
        System.out.println("x");
        return "components/todo-list"; // Assuming you have a view named todo-list.html or todo-list.jsp
    }

    @PostMapping
    public String addNewTodo(@ModelAttribute("todoDto") @Validated TodoDto todoDto, BindingResult result) throws RequestBodyEmptyException {
        if (result.hasErrors()) {
            // Handle validation errors
            return "components/todo-form"; // Assuming you have a view named todo-form.html or todo-form.jsp
        }
        Todo todo = todoService.saveTodo(todoDto);
        return "redirect:/todos"; // Redirect to the todo list page
    }

    @PutMapping
    public String updateTodo(@ModelAttribute("todo") @Validated Todo todo, BindingResult result) throws TodoNotFoundException {
        if (result.hasErrors()) {
            // Handle validation errors
            return "components/todo-edit"; // Assuming you have a view named todo-edit.html or todo-edit.jsp
        }
        Todo updatedTodo = todoService.updateTodo(todo);
        return "redirect:/todos"; // Redirect to the todo list page
    }
}
