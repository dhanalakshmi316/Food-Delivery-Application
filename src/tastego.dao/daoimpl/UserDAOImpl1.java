package com.tastego.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tastego.dao.UserDAO;
import com.tastego.model.User;
import com.tastego.util.DBConnection;

public class UserDAOImpl implements UserDAO {

    private Connection connection;

    public UserDAOImpl() {
        connection = DBConnection.getConnection();
    }

    @Override
    public boolean registerUser(User user) {

        String sql = "INSERT INTO users(full_name,email,phone,password,address,otp,otp_verified) VALUES(?,?,?,?,?,?,?)";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, user.getFullName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getAddress());
            ps.setString(6, user.getOtp());
            ps.setBoolean(7, user.isOtpVerified());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
