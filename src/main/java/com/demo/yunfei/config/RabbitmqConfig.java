package com.demo.yunfei.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Author: yunfei
 * @Date: 2018/8/23 10:59
 */
@Configuration
public class RabbitmqConfig {

    @Bean
    public Queue queue(){
        return new Queue("woqu");
    }
}
