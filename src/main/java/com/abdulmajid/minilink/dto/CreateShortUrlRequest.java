package com.abdulmajid.minilink.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateShortUrlRequest {

    @NotBlank(message = "Original URL is required")
    @Pattern(
            regexp = "^(http|https)://.*$",
            message = "Please provide a valid URL starting with http:// or https://"
    )
    private String originalUrl;

    @Size(max = 50, message = "Custom alias cannot exceed 50 characters")
    private String customAlias;
    private LocalDateTime expiresAt;
}