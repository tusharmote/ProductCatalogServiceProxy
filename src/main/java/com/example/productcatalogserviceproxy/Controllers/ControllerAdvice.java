package com.example.productcatalogserviceproxy.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ControllerAdvice {
    @ExceptionHandler(Exception.class)
    private ResponseEntity<String> exceptionHandler(){
        return new ResponseEntity<>("Invalid parameter", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
