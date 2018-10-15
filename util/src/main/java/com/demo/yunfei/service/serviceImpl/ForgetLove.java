package com.demo.yunfei.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.demo.yunfei.service.YunfeiService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author: yunfei
 * @Date: 2018/8/29 10:01
 */
@Service
public class ForgetLove implements YunfeiService {


    @Override
    public String getCode() {
        return "FORGET";
    }

    @Override
    public void love(String type) {
        System.out.println("yunfei forget"+type);
    }
}
