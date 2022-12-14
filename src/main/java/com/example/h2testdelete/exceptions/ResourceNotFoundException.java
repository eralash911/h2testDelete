package com.example.h2testdelete.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException (String message) {
        super(message);
    }
}
