package com.example.springsocial.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessage {
    //mã statusCode này do app qui định, ko liên quan đến HTTP StatusCode
    private int statusCode;
    private String message;
}

