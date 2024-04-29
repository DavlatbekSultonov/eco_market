package com.example.foodtrove0.common.exceptions;


public class IncorrectPassword extends RuntimeException {
    public IncorrectPassword(String message) {
        super(message);
    }
}