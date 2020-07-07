package com.ronaldlopez.trading.controller;

public class UserNotFoundException extends RuntimeException{

    UserNotFoundException(Integer id) {
        super("Could not find user " + id);
    }
}
