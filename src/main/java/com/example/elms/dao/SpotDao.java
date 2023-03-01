package com.example.elms.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SpotDao {
    List<Map<Object, Object>> getSpotList(String id);
}
