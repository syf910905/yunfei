package com.demo.yunfei.service.serviceImpl;

import com.alibaba.fastjson.JSON;

import java.util.Map;

/**
 * @Author: yunfei
 * @Date: 2018/8/29 10:02
 */
public class ForeverLove extends YunfeiAbstractLove {
    @Override
    public void love() {
        Map<String, Object> params = getParams();
        System.out.println("yunfei ..forever"+ JSON.toJSONString(params));
    }
}
