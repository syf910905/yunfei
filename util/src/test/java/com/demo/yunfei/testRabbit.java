package com.demo.yunfei;

import com.demo.yunfei.rabbitmq.RabbitmqSender;
import com.demo.yunfei.service.YunfeiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author: yunfei
 * @Date: 2018/8/23 16:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class testRabbit {
    @Autowired
    YunfeiService yunfeiService;

    @Resource
    private RabbitmqSender rabbitmqSender;

    @Test
    public void sayWoQu(){
        for (int i = 0; i < 10; i++) {
            rabbitmqSender.sayWoQu(i+"");
        }
    }

    @Test
    public void testfactory() throws  Exception{

        new Thread(new Runnable() {
            @Override
            public void run() {
                yunfeiService.love("1");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                yunfeiService.love("2");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                yunfeiService.love("3");
            }
        }).start();
        Thread.sleep(10000L);
    }

}
