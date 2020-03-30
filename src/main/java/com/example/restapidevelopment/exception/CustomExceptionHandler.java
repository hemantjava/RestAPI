package com.example.restapidevelopment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CustomExceptionHandler
{

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex)
    {
        ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<ErrorResponse>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnAuthenticException.class)
    public final ResponseEntity<ErrorResponse> handleUnAuthenticException(UnAuthenticException ex)
    {
        ErrorResponse error = new ErrorResponse(HttpStatus.FORBIDDEN.value(),ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<ErrorResponse>(error,HttpStatus.FORBIDDEN);
    }

}