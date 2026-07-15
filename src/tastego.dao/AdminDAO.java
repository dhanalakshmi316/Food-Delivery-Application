package com.tastego.dao;

import com.tastego.model.Admin;

public interface AdminDAO {

    Admin login(String username, String password);

}
