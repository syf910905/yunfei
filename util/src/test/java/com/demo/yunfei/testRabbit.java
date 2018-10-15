package com.demo.yunfei;

import com.demo.yunfei.common.ApplicationContextUtis;
import com.demo.yunfei.rabbitmq.RabbitmqSender;
import com.demo.yunfei.service.YunfeiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author: yunfei
 * @Date: 2018/8/23 16:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class testRabbit {

    private YunfeiService yunfeiService;

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
        Map<String, YunfeiService> map = ApplicationContextUtis.getBeansOfType(YunfeiService.class);
       for (Map.Entry<String, YunfeiService> entry:map.entrySet()) {
           yunfeiService= entry.getValue();
           yunfeiService.love( yunfeiService.getCode());
       }
      final   List<YunfeiService> list = map.values().stream().collect(Collectors.toList());


        new Thread(new Runnable() {
            @Override
            public void run() {
                yunfeiService = list.stream().filter(yunfei -> yunfei.getCode().equals("SYSTEM")).findFirst().orElse(null);
                yunfeiService.love(yunfeiService.getCode());
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                yunfeiService = list.stream().filter(yunfei -> yunfei.getCode().equals("FORGET")).findFirst().orElse(null);
                yunfeiService.love(yunfeiService.getCode());
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                yunfeiService = list.stream().filter(yunfei -> yunfei.getCode().equals("FOREVER")).findFirst().orElse(null);
                yunfeiService.love(yunfeiService.getCode());
            }
        }).start();
        Thread.sleep(10000L);
    }

}
