package com.example.api;

public class AppError {
    private String message;
    private int statusCode;

    public AppError(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }
}
