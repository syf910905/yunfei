package com.demo.yunfei.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 上下文
 *
 * @author : yunfei
 * @date : 2018/9/29 10:24
 */
@Component
public class ApplicationContextUtis implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextUtis.applicationContext = applicationContext;
    }

    /**
     * 获取 applicationContext
     *
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 通过class获取Bean
     *
     * @param classz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> classz) {
        return applicationContext.getBean(classz);
    }

    /**
     * 获取clazz类型的bean实例
     *
     * @param classz
     * @param <T>
     * @return
     */
    public static <T> Map<String, T> getBeansOfType(Class<T> classz) {
        return getApplicationContext().getBeansOfType(classz);
    }
}
