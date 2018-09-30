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

    /**
     * Hello word
     * @return
     */
    @Bean
    public Queue queue(){
        return new Queue("woqu");
    }

    /**
     * 工作模式
     * @return
     */
    @Bean
    public Queue work(){
        return new Queue("work");
    }
}
