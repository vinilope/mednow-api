package com.mednow.mednowapi.dtos.requests;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

public record MethodArgumentNotValidExceptionRequest(
        HttpStatus error,
        int status,
        LocalDateTime timestamp,
        Map<String, String> fields
) {}