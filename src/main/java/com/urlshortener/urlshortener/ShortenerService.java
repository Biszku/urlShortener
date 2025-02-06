package com.urlshortener.urlshortener;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ShortenerService {
    private final CodeGenerator codeGenerator;
    private final static Map<String, String> urls;

    static {
        urls = new HashMap<>();
    }

    public ShortenerService() {
        this.codeGenerator = new CodeGenerator();
    }

    public String shortenUrl(String url) {
        String shortUrl = "http://localhost:8080/" +
                codeGenerator.generateCode();
        urls.put(url, shortUrl);
        return shortUrl;
    }
}
