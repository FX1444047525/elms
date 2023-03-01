package com.example.elms.dao;

import com.example.elms.model.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDao {
    List<Order> getOrder();
}
