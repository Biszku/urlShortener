package com.urlshortener.urlshortener;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Service
public class ShortenerService {
    private final CodeGenerator codeGenerator;
    private final static Map<String, String> urlsAndCodes;
    private final static Map<String, String> codesAndUrls;

    static {
        urlsAndCodes = new HashMap<>();
        codesAndUrls = new HashMap<>();
    }

    public ShortenerService() {
        this.codeGenerator = new CodeGenerator();
    }

    public String shortenUrl(String url) {
        System.out.println("Shortening url: " + url);
        if (urlsAndCodes.get(url) != null) {
            return "http://localhost:8080/" + urlsAndCodes.get(url);
        }
        String code = codeGenerator.generateCode();
        urlsAndCodes.put(url, code);
        codesAndUrls.put(code, url);
        return "http://localhost:8080/" + code;
    }

    public HttpHeaders releaseUrl(String code) {
        HttpHeaders headers = new HttpHeaders();
        String originalUrl = codesAndUrls.get(code);
        headers.setLocation(URI.create(originalUrl));
        return headers;
    }
}
