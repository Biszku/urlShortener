package com.urlshortener.urlshortener;

import java.util.Stack;

public class CodeGenerator {
    private static int latestId = 0;
    private final static Stack<Integer> codes;

    static {
        codes = new Stack<>();
    }

    public String generateCode() {
        int code = latestId++;
        codes.add(code);
        return String.valueOf(code);
    }

    public boolean isCodesStorageEmpty() {
        return codes.isEmpty();
    }

    public String getLatestCodeAndDelete() {
        return String.valueOf(codes.pop());
    }
}
