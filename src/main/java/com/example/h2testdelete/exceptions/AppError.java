package com.example.h2testdelete.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AppError {
    private String message;
    private int statusCode;

    public AppError(int statusCode, String message) {
        this.message = message;
        this.statusCode = statusCode;
    }

}
