package com.abdulmajid.minilink.controller;

import com.abdulmajid.minilink.service.ShortUrlService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Redirect APIs", description = "APIs for URL redirection")
public class RedirectController {

    private final ShortUrlService shortUrlService;

    @GetMapping("/{shortCode}")
    @Operation(
            summary = "Redirect To Original URL",
            description = "Redirects user to the original long URL"
    )
    @ApiResponse(
            responseCode = "302",
            description = "Redirect successful"
    )
    public RedirectView redirectToOriginalUrl(
            @PathVariable String shortCode
    ) {

        String originalUrl =
                shortUrlService.getOriginalUrl(shortCode);

        return new RedirectView(originalUrl);
    }
}