package com.urlshortener.urlshortener;

import java.util.Stack;

public class CodeGenerator {
    private static final String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static long latestId = 0;
    private final static Stack<String> codes;

    static {
        codes = new Stack<>();
    }

    public String generateCode() {
        long id = latestId++;
        String code = getRandomChar() + String.format("%5s",  Base62.encode(id))
                .replace(' ', '0') + getRandomChar();
        codes.add(code);
        return code;
    }

    private char getRandomChar() {
        return characters.charAt((int) (Math.random() * characters.length()));
    }
}
