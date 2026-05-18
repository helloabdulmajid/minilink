package com.abdulmajid.minilink.service;

import com.abdulmajid.minilink.dto.CreateShortUrlRequest;
import com.abdulmajid.minilink.dto.ShortUrlResponse;

public interface ShortUrlService {

    ShortUrlResponse createShortUrl(CreateShortUrlRequest request);
    String getOriginalUrl(String shortCode);
}