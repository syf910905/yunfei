package com.demo.yunfei.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 发布订阅模式配置  交换机
 * @Author: yunfei
 * @Date: 2018/8/23 17:02
 */
@Configuration
public class RabbitmqFanoutConfig {

    @Bean
    public Queue publishA(){
        return new Queue("publishA");
    }

    @Bean
    public Queue publishB(){
        return new Queue("publishB");
    }

    @Bean
    public Queue publishC(){
        return new Queue("publishC");
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        return  new FanoutExchange("fanoutExchange");
    }

    @Bean
    public Binding bindingExchangeA(Queue publishA,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(publishA).to(fanoutExchange);
    }

    @Bean
    public Binding bindingExchangeB(Queue publishB,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(publishB).to(fanoutExchange);
    }

    @Bean
    public Binding bindingExchangeC(Queue publishC,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(publishC).to(fanoutExchange);
    }


   /* public TopicExchange topicExchange(){
        return new TopicExchange("topicExchange");
    }*/


}
