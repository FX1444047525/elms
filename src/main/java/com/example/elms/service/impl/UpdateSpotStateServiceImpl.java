package com.example.elms.service.impl;

import com.example.elms.dao.UpdateSpotStateDao;
import com.example.elms.service.UpdateSpotStateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.security.auth.login.LoginException;
import java.util.HashMap;
import java.util.Map;

@Service
public class UpdateSpotStateServiceImpl implements UpdateSpotStateService {
    @Resource
    private UpdateSpotStateDao updateSpotStateDao;

    public int update(String id, String state) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("id", id);
        map.put("state", state);

        int num = updateSpotStateDao.update(map);

        if (num == 1) {
            System.out.println("更新状态成功！");
            return num;
        } else {
            System.out.println("更新状态失败！");
            return -1;
        }

    }
}
