package com.example.application.demo.Exception;

import com.example.application.demo.entity.User;

import java.util.function.Supplier;

public class UserNotFoundException extends Exception {

    public UserNotFoundException(String s) {
        super(s);
    }

    public UserNotFoundException(){}

}
