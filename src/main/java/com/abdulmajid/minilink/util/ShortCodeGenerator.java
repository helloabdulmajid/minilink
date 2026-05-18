package com.abdulmajid.minilink.util;

import java.security.SecureRandom;

public class ShortCodeGenerator {

    private static final String CHARACTERS =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    private static final int SHORT_CODE_LENGTH = 6;

    private static final SecureRandom random = new SecureRandom();

    public static String generateShortCode() {

        StringBuilder shortCode = new StringBuilder();

        for (int i = 0; i < SHORT_CODE_LENGTH; i++) {

            int randomIndex = random.nextInt(CHARACTERS.length());

            shortCode.append(CHARACTERS.charAt(randomIndex));
        }

        return shortCode.toString();
    }
}