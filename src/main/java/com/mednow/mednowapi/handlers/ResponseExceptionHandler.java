package com.mednow.mednowapi.handlers;

import exceptions.ReponseException;
import com.mednow.mednowapi.dtos.requests.ResponseExceptionRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ResponseExceptionHandler {

    @ExceptionHandler(value = ReponseException.class)
    public ResponseEntity<Object> handleClinicaNotFoundException(ReponseException reponseException) {

        ResponseExceptionRequest responseExceptionRequest = new ResponseExceptionRequest(
                HttpStatus.NOT_FOUND,
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now(),
                reponseException.getMessage()
        );

        return ResponseEntity.status(responseExceptionRequest.status()).body(responseExceptionRequest);
    }
}
