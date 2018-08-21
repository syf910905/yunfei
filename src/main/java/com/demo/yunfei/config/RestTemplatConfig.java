package com.demo.yunfei.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: yunfei
 * @Date: 2018/8/21 9:32
 */
@Configuration
public class RestTemplatConfig {

    private static final int DEFAULT_READ_TIME_OUT = 900000;

    private static final int DEFAULT_CONNECT_TIME_OUT = 50000;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate(clientHttpRequestFactory());
    }


    private ClientHttpRequestFactory clientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(DEFAULT_CONNECT_TIME_OUT);
        factory.setReadTimeout(DEFAULT_READ_TIME_OUT);
        return factory;
    }
}
