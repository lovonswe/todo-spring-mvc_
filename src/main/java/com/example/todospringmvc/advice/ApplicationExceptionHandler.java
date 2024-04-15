package com.example.todospringmvc.advice;

import com.example.todospringmvc.exception.RequestBodyEmptyException;
import com.example.todospringmvc.exception.TodoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApplicationExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleInvalidArgument(MethodArgumentNotValidException exception, Model model){
        model.addAttribute("message", exception.getMessage());
        return "error";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(TodoNotFoundException.class)
    public String handleBusinessException(TodoNotFoundException exception, Model model){
        model.addAttribute("message", exception.getMessage());
        return "error";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RequestBodyEmptyException.class)
    public String handleRequestBodyEmptyException(RequestBodyEmptyException exception, Model model){
        model.addAttribute("message", exception.getMessage());
        return "error";
    }
}
