package com.abdulmajid.minilink.service.impl;

import com.abdulmajid.minilink.dto.CreateShortUrlRequest;
import com.abdulmajid.minilink.dto.ShortUrlResponse;
import com.abdulmajid.minilink.dto.UrlAnalyticsResponse;
import com.abdulmajid.minilink.entity.ShortUrl;
import com.abdulmajid.minilink.exception.DuplicateShortCodeException;
import com.abdulmajid.minilink.exception.ShortUrlExpiredException;
import com.abdulmajid.minilink.exception.ShortUrlNotFoundException;
import com.abdulmajid.minilink.repository.ShortUrlRepository;
import com.abdulmajid.minilink.service.ShortUrlService;
import com.abdulmajid.minilink.util.ShortCodeGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ShortUrlServiceImpl implements ShortUrlService {

    private final ShortUrlRepository shortUrlRepository;

    @Override
    public ShortUrlResponse createShortUrl(CreateShortUrlRequest request) {

        String shortCode;

        if (request.getCustomAlias() != null &&
                !request.getCustomAlias().isBlank()) {

            if (shortUrlRepository.existsByShortCode(
                    request.getCustomAlias())) {

                 throw new DuplicateShortCodeException(
                        "Custom alias already exists");
            }

            shortCode = request.getCustomAlias().trim();

        } else {

            shortCode = generateUniqueShortCode();
        }

        ShortUrl shortUrl = ShortUrl.builder()
                .originalUrl(request.getOriginalUrl())
                .shortCode(shortCode)
                .customAlias(request.getCustomAlias())
                .expiresAt(request.getExpiresAt())
                .build();

        ShortUrl savedUrl = shortUrlRepository.save(shortUrl);

        return ShortUrlResponse.builder()
                .originalUrl(savedUrl.getOriginalUrl())
                .shortCode(savedUrl.getShortCode())
                .shortUrl("https://minilink-twtn.onrender.com" + savedUrl.getShortCode())
                .customAlias(savedUrl.getCustomAlias())
                .clickCount(savedUrl.getClickCount())
                .createdAt(savedUrl.getCreatedAt())
                .expiresAt(savedUrl.getExpiresAt())
                .build();
    }

    private String generateUniqueShortCode() {

        String shortCode;

        do {
            shortCode = ShortCodeGenerator.generateShortCode();
        }
        while (shortUrlRepository.existsByShortCode(shortCode));

        return shortCode;
    }

    @Override
    public String getOriginalUrl(String shortCode) {

        ShortUrl shortUrl = shortUrlRepository
                .findByShortCode(shortCode)
                .orElseThrow(() ->
                                new ShortUrlNotFoundException("Short URL not found"));
        shortUrl.setClickCount(shortUrl.getClickCount() + 1);

        if (shortUrl.getExpiresAt() != null &&
                shortUrl.getExpiresAt().isBefore(LocalDateTime.now())) {

            throw new ShortUrlExpiredException("Short URL has expired");
        }

        shortUrlRepository.save(shortUrl);

        return shortUrl.getOriginalUrl();
    }

    @Override
    public UrlAnalyticsResponse getUrlAnalytics(String shortCode) {

        ShortUrl shortUrl = shortUrlRepository
                .findByShortCode(shortCode)
                .orElseThrow(() ->
                        new ShortUrlNotFoundException(
                                "Short URL not found"
                        ));

        return UrlAnalyticsResponse.builder()
                .originalUrl(shortUrl.getOriginalUrl())
                .shortCode(shortUrl.getShortCode())
                .clickCount(shortUrl.getClickCount())
                .createdAt(shortUrl.getCreatedAt())
                .expiresAt(shortUrl.getExpiresAt())
                .active(shortUrl.getActive())
                .build();
    }
}