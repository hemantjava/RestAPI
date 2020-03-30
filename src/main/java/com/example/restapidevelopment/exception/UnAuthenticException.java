package com.example.restapidevelopment.exception;

public class UnAuthenticException extends RuntimeException {
    public UnAuthenticException(String error){
        super(error);
    }
}
