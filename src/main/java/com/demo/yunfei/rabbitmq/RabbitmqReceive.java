package com.demo.yunfei.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: yunfei
 * @Date: 2018/8/23 15:50
 */
@Component
public class RabbitmqReceive {

    @RabbitListener(queues = "woqu")
    public void sayWoQu(String id){
        System.out.println("每秒都有人say wo qu +"+id);
    }
}
