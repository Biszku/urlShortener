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
        String code = String.format("%5s",  Base62.encode(id))
                .replace(' ', '0') + generateSuffix((byte) 2);
        codes.add(code);
        return code;
    }

    private String generateSuffix(byte length) {
        String suffix = "";
        for (int i = 0; i < length; i++) {
            suffix += characters.charAt((int) (Math.random() * characters.length()));
        }
        return suffix;
    }
}
