package com.ribbon.demo.serviceribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author : yunfei
 * @date : 2018/10/8 10:10
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    public String sayHello(String name){

        return restTemplate.getForObject("http://service-hi/hi/?name="+name,String.class);
    }
}
