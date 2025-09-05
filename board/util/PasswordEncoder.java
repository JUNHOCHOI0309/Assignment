package com.multi.board.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncoder {
    public static String encode(String rawPassword){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(rawPassword.getBytes(StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();
            for(byte b : hash){
                String hex = Integer.toHexString(0xff & b);
                if(hex.length() == 1) sb.append('0');
                sb.append(hex);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e){
            throw new RuntimeException("Password encoding error : "+ e);
        }
    }

    public static boolean matches(String rawPassword, String encodedPassword){
        return encode(rawPassword).equals(encodedPassword);
    }
}
