package com.example.elms.controller;

import com.example.elms.service.UpdateSpotStateService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.security.auth.login.LoginException;

@Controller
public class SpotController {

    @Resource
    private UpdateSpotStateService updateSpotStateService;

    //更新任务节点完成状态
    @RequestMapping("/spot/update")
    @ResponseBody
    public boolean UpdateSpot(String id, String state) throws LoginException {

        int num = updateSpotStateService.update(id, state);
        if (num == 1) {
            //更新成功，返回true
            return true;
        } else {
            //更新失败，返回false
            return false;
        }
    }
}
