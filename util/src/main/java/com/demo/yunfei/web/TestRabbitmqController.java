package com.demo.yunfei.web;

import com.demo.yunfei.rabbitmq.RabbitmqSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Author: yunfei
 * @Date: 2018/8/23 15:55
 */
@Controller
public class TestRabbitmqController {

    @Autowired
    private RabbitmqSender rabbitmqSender;
}
