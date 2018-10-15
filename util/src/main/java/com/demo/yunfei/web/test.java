package com.demo.yunfei.web;

import java.net.URLEncoder;

/**
 * @author : yunfei
 * @date : 2018/10/10 14:54
 */
public class test {
    public static void main(String[] args) throws Exception{
        String encode = URLEncoder.encode(" ", "utf-8");
        System.out.println(encode);
    }
}
