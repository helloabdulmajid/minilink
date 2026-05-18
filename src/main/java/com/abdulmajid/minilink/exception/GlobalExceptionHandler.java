package com.abdulmajid.minilink.exception;

import com.abdulmajid.minilink.dto.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ShortUrlNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleShortUrlNotFoundException(
            ShortUrlNotFoundException ex
    ) {

        ApiErrorResponse response = ApiErrorResponse.builder()
                .success(false)
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ExceptionHandler(ShortUrlExpiredException.class)
    public ResponseEntity<ApiErrorResponse> handleShortUrlExpiredException(
            ShortUrlExpiredException ex
    ) {

        ApiErrorResponse response = ApiErrorResponse.builder()
                .success(false)
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity
                .status(HttpStatus.GONE)
                .body(response);
    }
}