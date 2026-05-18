package com.abdulmajid.minilink.controller;

import com.abdulmajid.minilink.dto.CreateShortUrlRequest;
import com.abdulmajid.minilink.dto.ShortUrlResponse;
import com.abdulmajid.minilink.dto.UrlAnalyticsResponse;
import com.abdulmajid.minilink.service.ShortUrlService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1/urls")
@RequiredArgsConstructor

@Tag(name = "Short URL APIs", description = "APIs for URL shortening and analytics")
public class ShortUrlController {

    private final ShortUrlService shortUrlService;

    @PostMapping
    @Operation(
            summary = "Create Short URL",
            description = "Creates a shortened URL with optional custom alias and expiration"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Short URL created successfully"
    )
    public ResponseEntity<ShortUrlResponse> createShortUrl(
            @Valid @RequestBody CreateShortUrlRequest request
    ) {

        ShortUrlResponse response =
                shortUrlService.createShortUrl(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{shortCode}/analytics")
    @Operation(
            summary = "Get URL Analytics",
            description = "Fetch analytics details including click count and expiration"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Analytics fetched successfully"
    )
    public ResponseEntity<UrlAnalyticsResponse> getUrlAnalytics(
            @PathVariable String shortCode
    ) {

        UrlAnalyticsResponse response =
                shortUrlService.getUrlAnalytics(shortCode);

        return ResponseEntity.ok(response);
    }

}