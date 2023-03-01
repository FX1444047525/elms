package com.example.elms.service.impl;


import com.example.elms.dao.LocationPlanDao;
import com.example.elms.service.GetHtmlService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GetHtmlServiceImpl implements GetHtmlService {
    @Resource
    private LocationPlanDao locationPlanDao;

    public String gethtml(String id) {

        String html = locationPlanDao.getHtml(id);
        return html;
    }
}
