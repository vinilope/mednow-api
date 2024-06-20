package com.mednow.mednowapi.dtos.requests;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ResponseExceptionRequest(HttpStatus error, int status, LocalDateTime timestamp, String message) {
}
