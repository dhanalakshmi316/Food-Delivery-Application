package com.tastego.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tastego.dao.OTPDAO;
import com.tastego.util.DBConnection;

public class OTPDAOImpl implements OTPDAO {

    private Connection connection;

    public OTPDAOImpl() {
        connection = DBConnection.getConnection();
    }

    @Override
    public boolean saveOTP(String email, String otp) {

        String sql = "INSERT INTO otp_logs(email, otp) VALUES(?, ?)";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, otp);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public String getOTP(String email) {

        String sql = "SELECT otp FROM otp_logs WHERE email=? ORDER BY otp_id DESC LIMIT 1";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("otp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean deleteOTP(String email) {

        String sql = "DELETE FROM otp_logs WHERE email=?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, email);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}
