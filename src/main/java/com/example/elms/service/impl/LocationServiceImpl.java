package com.example.elms.service.impl;

import com.example.elms.dao.LocationPlanDao;
import com.example.elms.service.LocationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class LocationServiceImpl implements LocationService {
    @Resource
    private LocationPlanDao locationPlanDao;

    @Override
    public int save(String id, String location, String all_dist, String best_distlist, String htmlfile, String creat_time) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("id", id);
        map.put("location", location);
        map.put("all_dist", all_dist);
        map.put("best_distlist", best_distlist);
        map.put("htmlfile", htmlfile);
        map.put("creat_time", creat_time);

        int num = locationPlanDao.save(map);
        if (num == 1) {
            System.out.println("路径规划信息保存成功！");
            return num;
        } else {
            return -1;
        }
    }
}
