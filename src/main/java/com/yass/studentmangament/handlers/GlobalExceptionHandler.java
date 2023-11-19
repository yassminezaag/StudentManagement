package com.yass.studentmangament.handlers;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String HandleExceptions(MethodArgumentNotValidException e){
        StringBuilder errors = new StringBuilder();
        for (ObjectError error : e.getBindingResult().getAllErrors()) {
            var fieldName = ((FieldError) error).getField();
            var errorMsg = error.getDefaultMessage();
            errors.append(fieldName).append("-").append(errorMsg).append("\n");
        }
        return errors.toString();
    }
}
