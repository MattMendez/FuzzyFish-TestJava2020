package com.challenge.ecommerce.controllers;

import com.challenge.ecommerce.dto.ExceptionDto;
import com.challenge.ecommerce.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = EmptySearchException.class)
    public ResponseEntity<ExceptionDto> EmptySearchHandler(EmptySearchException ex){
        ExceptionDto exceptionDto = ExceptionDto.builder().code(ex.getCode()).message(ex.getMessage()).build();
        return new ResponseEntity<>(exceptionDto, ex.getStatus());
    }

    @ExceptionHandler(value = SqlException.class)
    public ResponseEntity<ExceptionDto> SqlHandler(SqlException ex){
        ExceptionDto exceptionDto = ExceptionDto.builder().code(ex.getCode()).message(ex.getMessage()).build();
        return new ResponseEntity<>(exceptionDto, ex.getStatus());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDto> MethodArgumentNotValidHandler(MethodArgumentNotValidException ex){
        ExceptionDto exceptionDto = ExceptionDto.builder().code("400").message(ex.getMessage()).build();
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }

}
