package com.abdulmajid.minilink.service.impl;

import com.abdulmajid.minilink.dto.CreateShortUrlRequest;
import com.abdulmajid.minilink.dto.ShortUrlResponse;
import com.abdulmajid.minilink.entity.ShortUrl;
import com.abdulmajid.minilink.exception.ShortUrlNotFoundException;
import com.abdulmajid.minilink.repository.ShortUrlRepository;
import com.abdulmajid.minilink.service.ShortUrlService;
import com.abdulmajid.minilink.util.ShortCodeGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShortUrlServiceImpl implements ShortUrlService {

    private final ShortUrlRepository shortUrlRepository;

    @Override
    public ShortUrlResponse createShortUrl(CreateShortUrlRequest request) {

        String shortCode = generateUniqueShortCode();

        ShortUrl shortUrl = ShortUrl.builder()
                .originalUrl(request.getOriginalUrl())
                .shortCode(shortCode)
                .customAlias(request.getCustomAlias())
                .build();

        ShortUrl savedUrl = shortUrlRepository.save(shortUrl);

        return ShortUrlResponse.builder()
                .originalUrl(savedUrl.getOriginalUrl())
                .shortCode(savedUrl.getShortCode())
                .shortUrl("http://localhost:8080/" + savedUrl.getShortCode())
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

        shortUrlRepository.save(shortUrl);

        return shortUrl.getOriginalUrl();
    }
}