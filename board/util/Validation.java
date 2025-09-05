package com.multi.board.util;

import java.util.regex.Pattern;

public class Validation {
    private static final Pattern ID_PATTERN = Pattern.compile("^[a-zA-Z0-9]{4,20}$");

    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");

    public static boolean isValidId(String memberId) {
        return memberId != null && ID_PATTERN.matcher(memberId).matches();
    }

    public static boolean isValidPassword(String password) {
        return password != null && PASSWORD_PATTERN.matcher(password).matches();
    }
}
