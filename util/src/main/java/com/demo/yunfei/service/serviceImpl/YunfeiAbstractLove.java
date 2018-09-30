package com.demo.yunfei.service.serviceImpl;

import com.demo.yunfei.service.Love;

import java.util.Map;

/**
 * @Author: yunfei
 * @Date: 2018/8/29 9:56
 */
public abstract class YunfeiAbstractLove implements Love {

    private Map<String,Object> params;

    @Override
    public Map<String, Object> getParams() {
        return params;
    }

    @Override
    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
