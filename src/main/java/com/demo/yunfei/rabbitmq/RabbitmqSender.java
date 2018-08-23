package com.demo.yunfei.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: yunfei
 * @Date: 2018/8/23 15:46
 */
@Component
public class RabbitmqSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sayWoQu(String id) {
        amqpTemplate.convertAndSend("woqu",id);
    }
}
