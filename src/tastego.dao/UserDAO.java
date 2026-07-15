package com.tastego.dao;

import com.tastego.model.User;

public interface UserDAO {

    boolean registerUser(User user);

    User login(String email, String password);

    User getUserByEmail(String email);

    boolean updatePassword(String email, String password);

    boolean verifyOTP(String email);

}
