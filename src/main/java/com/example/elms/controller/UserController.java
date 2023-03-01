package com.example.elms.controller;

import com.example.elms.model.Order;
import com.example.elms.wrapperclass.Test;
import com.example.elms.wrapperclass.Test1;
import com.example.elms.model.User;
import com.example.elms.service.GetHtmlService;
import com.example.elms.service.OrderService;
import com.example.elms.service.SpotService;
import com.example.elms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.security.auth.login.LoginException;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private OrderService orderService;
    @Resource
    private GetHtmlService getHtmlService;
    @Resource
    private SpotService spotService;

    //管理员登录，则返回所有订单
    //可以在@RequestMapping中设置请求方式：method = RequestMethod.GET
    @RequestMapping(value = "/administrator/queryOrder")
    @ResponseBody
    public Test GetOrder(String loginAct, String loginPwd) throws LoginException {
        User user = userService.login(loginAct, loginPwd);
        String identity = user.getIdentity();
        //验证登录的是管理员
        if (identity.equals("0")) {
            //取出所有未完成订单
            List<Order> order = orderService.getOrder();
            //将所有为完成订单的id从小到大拼接起来，借助拼接后的的id获取路径规划表里的html地址
            String id = "";
            for (int i = 0; i < order.size(); i++) {
                String s = order.get(i).getId();
                System.out.println("未完成订单的编号" + s);
                id = id + s;
            }
            System.out.println("拼接后的id" + id);

            //获取未完成订单对应的的html地址
            String html = getHtmlService.gethtml(id);
            System.out.println(html);

            //Test类用来封装List<Order>和html的
            Test test = new Test();
            test.setOrder(order);
            test.setHtml(html);
            return test;
        } else {
            //登录的不是管理员
            Test test2 = new Test();
            test2.setOrder(null);
            test2.setHtml("该登录用户不是管理员！");
            return test2;
        }
    }

    //登录的是配送员，则返回配送员昵称,该配送员的所有节点，路线规划图
    @RequestMapping("/courier/querySpot")
    @ResponseBody
    public Test1 GetSpot(String loginAct, String loginPwd) throws LoginException {
        User user = userService.login(loginAct, loginPwd);
        String identity = user.getIdentity();
        //验证登录的是配送员
        if (identity.equals("1")) {
            String id = user.getId();
            List<Map<Object, Object>> spot = spotService.getSpot(id);
            //获取配送员昵称，及该配送员需要配送的节点信息（地址，时间，状态）
            String name = user.getName();

            Test1 test = new Test1();
            test.setName(name);
            test.setSpotImf(spot);
            return test;
        } else {
            //登录的不是配送员
            Test1 test1 = new Test1();
            test1.setName("该登录用户不是配送员！");
            test1.setSpotImf(null);
            return test1;
        }
    }
}
