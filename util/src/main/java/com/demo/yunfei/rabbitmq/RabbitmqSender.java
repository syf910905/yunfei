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

    /**
     *  hello  world
     * @param id
     */
    public void sayWoQu(String id) {
        amqpTemplate.convertAndSend("woqu",id);
    }

    /**
     * 工作模式
     * @param id
     */
    public void Work(String id) {
        amqpTemplate.convertAndSend("work",id);
    }


    /**
     * 发布订阅模式
     * @param id
     */
    public void fanout(String id){
        amqpTemplate.convertAndSend("fanoutExchange","",id);
    }
}
