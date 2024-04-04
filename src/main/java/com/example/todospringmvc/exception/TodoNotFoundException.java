package com.example.todospringmvc.exception;

public class TodoNotFoundException extends Exception {

    public TodoNotFoundException ( String  message) {
        super(message);
    }
}
