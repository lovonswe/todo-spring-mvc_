package com.example.todospringmvc.advice;

import com.example.todospringmvc.exception.RequestBodyEmptyException;
import com.example.todospringmvc.exception.TodoNotFoundException;
import org.springframework.http.HttpStatus;
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
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException exception){
        Map<String, String> errorMap = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        return errorMap;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(TodoNotFoundException.class)
    public Map<String, String> handleBusinessException(TodoNotFoundException exception){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error Message", exception.getMessage() );
        return errorMap;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RequestBodyEmptyException.class)
    public Map<String, String> handleRequestBodyEmptyException(RequestBodyEmptyException exception){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error Message", exception.getMessage() );
        return errorMap;
    }
}
