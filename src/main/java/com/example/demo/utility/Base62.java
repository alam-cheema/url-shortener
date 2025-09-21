package com.example.demo.utility;

public class Base62 {

    private static final char[] ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final int BASE = ALPHABET.length;

    private Base62() {}

    public static String encode(long value) {
        if (value == 0) return "0";

        StringBuilder sb = new StringBuilder();
        while (value > 0) {
            int remainder = (int) (value % BASE);
            sb.append(ALPHABET[remainder]);
            value /= BASE;
        }
        return sb.reverse().toString();
    }

    public static long decode(String code) {
        long result = 0;
        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            result = result * BASE + charToValue(c);
        }
        return result;
    }

    private static int charToValue(char c) {
        if ('0' <= c && c <= '9') return c - '0';
        if ('a' <= c && c <= 'z') return c - 'a' + 10;
        if ('A' <= c && c <= 'Z') return c - 'A' + 36;
        throw new IllegalArgumentException("Invalid Base62 character: " + c);
    }
}
