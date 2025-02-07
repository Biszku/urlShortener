package com.urlshortener.urlshortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class ShortenerController {
    @Autowired
    private ShortenerService shortenerService;

    @PostMapping("/")
    public ResponseEntity<String> shortenUrl(@RequestParam String url) {
        return ResponseEntity.ok(shortenerService.shortenUrl(url));
    }

    @GetMapping("/{code}")
    public ResponseEntity<String> redirectToUrl(@PathVariable String code) {
        String url = shortenerService.releaseUrl(code);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(url));
        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }
}
