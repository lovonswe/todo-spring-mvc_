package com.example.todospringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todos")
public class TodoController {
    @GetMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("name", "Nahid");
        return "components/TodoList";
    }

    @PostMapping("")
}
