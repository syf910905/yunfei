package com.demo.yunfei.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.MapPropertySource;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : yunfei
 * @date : 2018/10/9 11:19
 */
@Configuration
public class RedisConfig {
    @Value("${spring.redis.cluster.nodes}")
    private String clusterNodes;

    @Value("${spring.redis.cluster.max-redirects}")
    private int maxRedirects;


    @Bean
    public RedisClusterConfiguration getClusterConfiguration() {
        Map<String, Object> map = new HashMap<>();
        map.put("spring.redis.cluster.nodes", clusterNodes);
        map.put("spring.redis.cluster.max-redirects", maxRedirects);
        RedisClusterConfiguration configuration = new RedisClusterConfiguration(new MapPropertySource("RedisClusterConfiguration", map));
        return configuration;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.redis")
    public JedisConnectionFactory getConnectionFactory() {
        RedisClusterConfiguration configuration = getClusterConfiguration();
        JedisConnectionFactory factory = new JedisConnectionFactory(configuration);
        return factory;
    }
}
