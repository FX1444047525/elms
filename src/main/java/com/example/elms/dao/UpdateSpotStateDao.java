package com.example.elms.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UpdateSpotStateDao {
    int update(Map<String, String> map);
}
