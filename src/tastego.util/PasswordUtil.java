package com.tastego.util;

public class PasswordUtil {

    public static String encryptPassword(String password) {

        return password;

    }

    public static boolean checkPassword(String password, String dbPassword) {

        return password.equals(dbPassword);

    }

}
