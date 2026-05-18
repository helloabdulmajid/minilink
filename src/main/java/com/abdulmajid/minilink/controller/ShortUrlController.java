package com.abdulmajid.minilink.controller;

import com.abdulmajid.minilink.dto.CreateShortUrlRequest;
import com.abdulmajid.minilink.dto.ShortUrlResponse;
import com.abdulmajid.minilink.service.ShortUrlService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/api/v1/urls")
@RequiredArgsConstructor
public class ShortUrlController {

    private final ShortUrlService shortUrlService;

    @PostMapping
    public ResponseEntity<ShortUrlResponse> createShortUrl(
            @Valid @RequestBody CreateShortUrlRequest request
    ) {

        ShortUrlResponse response =
                shortUrlService.createShortUrl(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{shortCode}")
    public RedirectView redirectToOriginalUrl(
            @PathVariable String shortCode
    ) {

        String originalUrl =
                shortUrlService.getOriginalUrl(shortCode);

        return new RedirectView(originalUrl);
    }
}