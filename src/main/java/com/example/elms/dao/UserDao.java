package com.example.elms.dao;

import com.example.elms.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDao {
    User login(Map<String, String> map);

    List<User> getUserList();
}
