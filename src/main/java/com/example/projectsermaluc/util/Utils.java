package com.example.projectsermaluc.util;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

public class Utils {

    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return email != null && pattern.matcher(email).matches();
    }

}
