package com.example.elms.wrapperclass;

import java.util.List;
import java.util.Map;

//用来封装UserController接口里返回给前端的数据
public class Test1 {
    private String name;
    private List<Map<Object, Object>> spotImf;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Map<Object, Object>> getSpotImf() {
        return spotImf;
    }

    public void setSpotImf(List<Map<Object, Object>> spotImf) {
        this.spotImf = spotImf;
    }
}
