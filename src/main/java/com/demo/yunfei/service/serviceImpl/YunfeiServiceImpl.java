package com.demo.yunfei.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.demo.yunfei.service.Love;
import com.demo.yunfei.service.YunfeiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yunfei
 * @Date: 2018/8/29 9:48
 */
@Service
public class YunfeiServiceImpl implements YunfeiService {

    @Override
    public void love(String type) {
        Love love;
        switch (type) {
            case "1":
                love = new ForeverLove();
                break;
            case "2":
                love = new MissLove();
                break;
            case "3":
                love = new ForgetLove();
                break;
            default:
                love = null;
                break;
        }
        Map<String,Object> map=new HashMap<>();
        map.put("type",type);
        love.setParams(map);
        love.love();
    }
}
