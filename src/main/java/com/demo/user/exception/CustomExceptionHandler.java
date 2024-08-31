package com.demo.user.exception;

import com.demo.user.model.response.CustomErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<?> handleNoSuchElementException(NoSuchElementException error){
        CustomErrorResponse resp = new CustomErrorResponse(HttpStatus.NOT_FOUND.value(), error.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
    }


}
