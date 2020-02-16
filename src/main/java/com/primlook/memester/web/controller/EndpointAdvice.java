package com.primlook.memester.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bernardo on 2/16/2020
 */
@ControllerAdvice
public class EndpointAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> validationErrorHandler(MethodArgumentNotValidException ex){
        List<String> errorList = new ArrayList<>();

        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            errorList.add("field" + fieldError.getObjectName() + " field " + fieldError.getField() +" code " + fieldError.getDefaultMessage());
        }
        //ex.getConstraintViolations().forEach(error -> errorList.add(error.toString()));

        return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
    }
}
