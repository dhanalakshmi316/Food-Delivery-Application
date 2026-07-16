package com.tastego.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tastego.dao.UserDAO;
import com.tastego.model.User;
import com.tastego.util.DBConnection;

public class UserDAOImpl implements UserDAO {

    private Connection con = DBConnection.getConnection();

    @Override
    public boolean registerUser(User user) {

        boolean status = false;

        try {

            String sql = "INSERT INTO users(full_name,email,phone,address,otp,otp_verified) VALUES(?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, user.getFullName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getAddress());
            ps.setString(5, user.getOtp());
            ps.setBoolean(6, false);

            status = ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    @Override
    public User login(String email, String password) {

        User user = null;

        try {

            String sql = "SELECT * FROM users WHERE email=? AND password=? AND otp_verified=true";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                user = new User();

                user.setUserId(rs.getInt("user_id"));
                user.setFullName(rs.getString("full_name"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setOtpVerified(rs.getBoolean("otp_verified"));
                user.setCreatedAt(rs.getTimestamp("created_at"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public User getUserByEmail(String email) {

        User user = null;

        try {

            String sql = "SELECT * FROM users WHERE email=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                user = new User();

                user.setUserId(rs.getInt("user_id"));
                user.setFullName(rs.getString("full_name"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setPassword(rs.getString("password"));
                user.setAddress(rs.getString("address"));
                user.setOtp(rs.getString("otp"));
                user.setOtpVerified(rs.getBoolean("otp_verified"));
                user.setCreatedAt(rs.getTimestamp("created_at"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public boolean updatePassword(String email, String password) {

        boolean status = false;

        try {

            String sql = "UPDATE users SET password=? WHERE email=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, password);
            ps.setString(2, email);

            status = ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    @Override
    public boolean verifyOTP(String email) {

        boolean status = false;

        try {

            String sql = "UPDATE users SET otp_verified=true WHERE email=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);

            status = ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}
