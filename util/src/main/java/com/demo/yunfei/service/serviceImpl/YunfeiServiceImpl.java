package com.demo.yunfei.service.serviceImpl;

import com.demo.yunfei.service.YunfeiService;
import org.springframework.stereotype.Service;


/**
 * @Author: yunfei
 * @Date: 2018/8/29 9:48
 */
@Service
public class YunfeiServiceImpl implements YunfeiService {

    @Override
    public String getCode() {
        return "SYSTEM";
    }

    @Override
    public void love(String type) {
        System.out.println("system...!!!"+ type);
    }
}
