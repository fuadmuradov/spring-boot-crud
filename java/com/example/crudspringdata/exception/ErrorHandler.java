package com.example.crudspringdata.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.example.crudspringdata.exception.ErrorConstants.UNEXPECTED_ERROR;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handle(Exception ex) {
        return new ErrorResponse(UNEXPECTED_ERROR.getCode(), UNEXPECTED_ERROR.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handle(NotFoundException ex) {
        return new ErrorResponse( ex.getMessage(), ex.getCode());
    }

}
