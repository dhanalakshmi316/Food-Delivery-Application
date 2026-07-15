package com.tastego.model;

import java.sql.Timestamp;

public class OTP {

    private int otpId;
    private String email;
    private String otp;
    private Timestamp generatedTime;

    public OTP() {
    }

    public OTP(int otpId, String email,
            String otp, Timestamp generatedTime) {

        this.otpId = otpId;
        this.email = email;
        this.otp = otp;
        this.generatedTime = generatedTime;
    }

    public int getOtpId() {
        return otpId;
    }

    public void setOtpId(int otpId) {
        this.otpId = otpId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public Timestamp getGeneratedTime() {
        return generatedTime;
    }

    public void setGeneratedTime(Timestamp generatedTime) {
        this.generatedTime = generatedTime;
    }
}
