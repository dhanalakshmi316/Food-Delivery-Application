package com.tastego.util;

import java.util.Random;

public class OTPGenerator {

    public static String generateOTP() {

        Random random = new Random();

        int otp = 10000 + random.nextInt(90000);

        return String.valueOf(otp);

    }

}
