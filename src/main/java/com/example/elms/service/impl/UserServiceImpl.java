package com.example.elms.service.impl;


import com.example.elms.dao.UserDao;
import com.example.elms.model.User;
import com.example.elms.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.security.auth.login.LoginException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    public User login(String loginAct, String loginPwd) throws LoginException {

        Map<String, String> map = new HashMap<String, String>();
        map.put("loginAct", loginAct);
        map.put("loginPwd", loginPwd);

        User user = userDao.login(map);

        if (user == null) {

            throw new LoginException("账号密码错误");

        }
        return user;
    }


    public List<User> getUserList() {

        List<User> uList = userDao.getUserList();

        return uList;
    }
}




































