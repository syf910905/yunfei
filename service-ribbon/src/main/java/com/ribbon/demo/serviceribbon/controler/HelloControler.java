package com.ribbon.demo.serviceribbon.controler;

import com.ribbon.demo.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : yunfei
 * @date : 2018/10/8 10:09
 */
@RestController
public class HelloControler {

    @Autowired
    HelloService helloService;

    @GetMapping(value = "/hi")
    public String getServiceName(@RequestParam String name){
        return helloService.sayHello(name);
    }
}
