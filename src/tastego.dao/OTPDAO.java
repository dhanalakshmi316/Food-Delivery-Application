package com.tastego.dao;

public interface OTPDAO {

    boolean saveOTP(String email, String otp);

    String getOTP(String email);

    boolean deleteOTP(String email);

}
