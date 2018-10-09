package com.demo.yunfei.demo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author : yunfei
 * @date : 2018/10/9 10:15
 */
@Setter
@Getter
public class Human {

    private String name;
    private int age;

    public Human() {
        super();
    }

    public Human(final String name, final int age) {
        super();
        this.name = name;
        this.age = age;
    }
}
