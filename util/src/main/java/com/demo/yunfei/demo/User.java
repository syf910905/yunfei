package com.demo.yunfei.demo;

import lombok.Data;

/**
 * @author : yunfei
 * @date : 2018/10/9 11:00
 */
@Data
public class User {
    private Long id;
    private String username;
    private Integer type;

    public User(final Long id,final String username,final Integer type){
        this.id=id;
        this.type=type;
        this.username=username;
    }
}
