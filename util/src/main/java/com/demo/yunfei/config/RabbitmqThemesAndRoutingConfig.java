package com.demo.yunfei.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: yunfei
 * @Date: 2018/8/24 10:01
 */
@Configuration
public class RabbitmqThemesAndRoutingConfig {

    private final static String queueA = "zhouritian.A";
    private final static String queueB = "zhouritian.B";

    @Bean
    public Queue queueZrtA() {
        return new Queue(RabbitmqThemesAndRoutingConfig.queueA);
    }

    @Bean
    public Queue queueZrtB() {
        return new Queue(RabbitmqThemesAndRoutingConfig.queueB);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }

}
