package com.example.jpalearnproject.common.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class BoardControllerAdvice {

    @ExceptionHandler(BoardException.class)
    public ResponseEntity<Map<String, Object>> BoardExceptionHandler(BoardException e) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("message", e.getMessage());
        return new ResponseEntity<>(responseBody, e.getStatus());
    }
}
