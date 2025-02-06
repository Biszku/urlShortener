package com.urlshortener.urlshortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ShortenerController {
    @Autowired
    private ShortenerService shortenerService;

    @PostMapping("")
    public ResponseEntity<String> shortenUrl(@RequestParam String url) {
        return ResponseEntity.ok(shortenerService.shortenUrl(url));
    }
}
