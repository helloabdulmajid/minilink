package com.abdulmajid.minilink.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ShortUrlResponse {

    private String originalUrl;

    private String shortCode;

    private String shortUrl;

    private String customAlias;

    private Long clickCount;

    private LocalDateTime createdAt;

    private LocalDateTime expiresAt;
}