package com.example.demo.controller;

import com.example.demo.entity.Url;
import com.example.demo.service.UrlService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/urls")
public class UrlController {
    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping
    public ResponseEntity<String> shorten(@RequestBody String longUrl) {
        Url url = urlService.createShortUrl(longUrl);
        return ResponseEntity.ok(url.getShortCode());
    }

    @GetMapping("/{code}")
    public ResponseEntity<String> resolve(@PathVariable String code) {
        return urlService.resolve(code)
                .map(url -> ResponseEntity.ok(url.getLongUrl()))
                .orElse(ResponseEntity.notFound().build());
    }
}
