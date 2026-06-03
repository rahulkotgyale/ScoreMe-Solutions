package com.scoreme.pipeline_scheduler.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(
            RuntimeException ex) {

        return new ResponseEntity<>(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(
            IllegalArgumentException ex) {

        return new ResponseEntity<>(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(
            NullPointerException ex) {

        return new ResponseEntity<>(
                "Null value encountered: " + ex.getMessage(),
                HttpStatus.BAD_REQUEST);
    }

   
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(
            Exception ex) {

        return new ResponseEntity<>(
                ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}