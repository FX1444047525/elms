package com.example.elms.service;

import com.example.elms.model.User;

import javax.security.auth.login.LoginException;
import java.util.List;

public interface UserService {
    User login(String loginAct, String loginPwd) throws LoginException;

    List<User> getUserList();
}
