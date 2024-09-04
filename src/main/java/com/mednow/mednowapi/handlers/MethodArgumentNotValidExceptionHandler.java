package com.mednow.mednowapi.handlers;

import com.mednow.mednowapi.dtos.requests.MethodArgumentNotValidExceptionRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MethodArgumentNotValidExceptionHandler {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<MethodArgumentNotValidExceptionRequest> handleMethodArgumentNotValidException(MethodArgumentNotValidException manve) {
        Map<String, String> fields = new HashMap<>();

        manve.getBindingResult().getAllErrors().forEach((error) -> {
            String field = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            fields.put(field, message);
        });

        MethodArgumentNotValidExceptionRequest methodArgumentNotValidExceptionRequest = new MethodArgumentNotValidExceptionRequest(
                HttpStatus.BAD_REQUEST,
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                fields
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(methodArgumentNotValidExceptionRequest);
    }
}
