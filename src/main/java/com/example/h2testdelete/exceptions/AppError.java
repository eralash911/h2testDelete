package com.example.h2testdelete.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AppError {
    private String message;
    private int statusCode;

    public AppError(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }
}
