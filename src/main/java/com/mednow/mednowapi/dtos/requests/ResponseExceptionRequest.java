package com.mednow.mednowapi.dtos.requests;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ResponseExceptionRequest(String message, HttpStatus error, int status, LocalDateTime timestamp) {
}
