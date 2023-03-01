package com.example.elms.controller;

import com.example.elms.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class SaveLocController {

    @Resource
    private LocationService locationService;

    //保存节点位置信息
    @RequestMapping("/location/save")
    @ResponseBody
    public boolean SaveLocation(String id, String location, String all_dist, String best_distlist, String htmlfile) {
        //获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");// a为am/pm的标记
        Date date = new Date();// 获取当前时间
        System.out.println("现在时间：" + sdf.format(date)); // 输出已经格式化的现在时间（24小时制）

        String creat_time = sdf.format(date);
        System.out.println(creat_time);

        int num = locationService.save(id, location, all_dist, best_distlist, htmlfile, creat_time);
        if (num == 1)
            //保存成功
            return true;
        else
            //保存失败
            return false;
    }
}
