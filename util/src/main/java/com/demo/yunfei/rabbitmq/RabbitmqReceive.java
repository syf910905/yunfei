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

    @RabbitListener(queues = "work")
    public void work(String work){
        System.out.println("小明做一个活计"+work);
    }

    @RabbitListener(queues = "work")
    public void work2(String work){
        System.out.println("小宁做一个活计"+work);
    }

    @RabbitListener(queues = "work")
    public void work3(String work){
        System.out.println("小老虎做一个活计"+work);
    }

    @RabbitListener(queues = "publishA")
    public void fanoutA(String fanout){
        System.out.println("fanouA 订阅了："+fanout);
    }

    @RabbitListener(queues = "publishB")
    public void fanoutB(String fanout){
        System.out.println("fanouB 订阅了："+fanout);
    }

    @RabbitListener(queues = "publishC")
    public void fanoutC(String fanout){
        System.out.println("fanouC 订阅了："+fanout);
    }


}
