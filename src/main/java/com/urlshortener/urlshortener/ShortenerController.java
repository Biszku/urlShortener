package com.urlshortener.urlshortener;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShortenerController {
    private final ShortenerService shortenerService = new ShortenerService();

    @PostMapping("/")
    public ResponseEntity<String> shortenUrl(@RequestParam String url) {
        return ResponseEntity.ok(shortenerService.shortenUrl(url));
    }

    @GetMapping("/{code}")
    public ResponseEntity<String> redirectToUrl(@PathVariable String code) {
        return new ResponseEntity<>(shortenerService.releaseUrl(code),
                HttpStatus.MOVED_PERMANENTLY);
    }
}
