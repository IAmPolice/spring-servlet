package com.serlvet.lib;

import java.util.Random;

public class GenerateId {
    static char[] chars = "1234567890abcdefghijklmnopqrstuvwxyz".toCharArray();
    static Random random = new Random();

    public static String forUserId() {
        StringBuilder sb = new StringBuilder();
        for (int iChar = 0; iChar < 10; iChar++) {
            sb.append(chars[random.nextInt(chars.length)]);
        }
        return sb.toString() + '-' + System.currentTimeMillis();
    }

    public static String forOrderId() {
        StringBuilder sb = new StringBuilder();
        for (int iChar = 0; iChar < 3; iChar++) {
            sb.append(chars[random.nextInt(chars.length)]);
        }
        return sb.toString() + '-' + System.currentTimeMillis();
    }
}
