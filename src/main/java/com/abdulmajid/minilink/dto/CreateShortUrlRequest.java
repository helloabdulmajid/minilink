package com.abdulmajid.minilink.dto;

import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateShortUrlRequest {

    @NotBlank(message = "Original URL is required")
    private String originalUrl;

    @Size(max = 50, message = "Custom alias cannot exceed 50 characters")
    private String customAlias;
    private LocalDateTime expiresAt;
}