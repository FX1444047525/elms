package com.example.elms.service.impl;

import com.example.elms.dao.OrderDao;
import com.example.elms.model.Order;
import com.example.elms.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    public List<Order> getOrder() {
        List<Order> order = orderDao.getOrder();
        return order;
    }
}
