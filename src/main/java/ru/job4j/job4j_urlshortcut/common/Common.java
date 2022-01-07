package ru.job4j.job4j_urlshortcut.common;

import java.util.Random;

public class Common {
    private static String allChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$";

    public static String generateString(int length) {
        Random random = new Random();
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = allChars.charAt(random.nextInt(allChars.length()));
        }
        return new String(text);
    }
}
