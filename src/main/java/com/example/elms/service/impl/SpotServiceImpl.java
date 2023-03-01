package com.example.elms.service.impl;


import com.example.elms.dao.SpotDao;
import com.example.elms.service.SpotService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class SpotServiceImpl implements SpotService {
    @Resource
    private SpotDao spotDao;

    @Override
    public List<Map<Object, Object>> getSpot(String id) {
        List<Map<Object, Object>> spot = spotDao.getSpotList(id);
        return spot;
    }
}
