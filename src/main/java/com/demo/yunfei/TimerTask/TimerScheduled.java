package com.demo.yunfei.TimerTask;

import com.demo.yunfei.rabbitmq.RabbitmqSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author: yunfei
 * @Date: 2018/8/23 16:17
 */
@Component
public class TimerScheduled {

    @Autowired
    private RabbitmqSender rabbitmqSender;
    private static int i=0;

    /**
     * 每秒都有人说我去
     */
    //@Scheduled(cron = "0/1 * * * * ? ")
    public void sayWoQu(){
        i++;
        rabbitmqSender.sayWoQu(i+"");
    }

    /**
     * 时刻都有人在工作
     */
    //@Scheduled(cron = "0/1 * * * * ? ")
    public void work(){
        i++;
        rabbitmqSender.Work(i+"");
    }

    /**
     * 时刻都有人在发布订阅
     */
    //@Scheduled(cron = "0/1 * * * * ? ")
    public void fanout(){
        i++;
        rabbitmqSender.fanout(i+"");
    }
}
