package com.example.elms.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface LocationPlanDao {
    int save(Map<String, String> map);

    String getHtml(String id);
}
