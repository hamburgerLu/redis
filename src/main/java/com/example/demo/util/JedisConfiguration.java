package com.example.demo.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by lu on 2018/6/6.
 */
@Component
public class JedisConfiguration {


    @Value("${jedis.port}")
    private Integer port;
    @Value("${jedis.host}")
    private String host;
    @Value("${jedis.max.total}")
    private Integer maxTotal;
    @Value("${jedis.max.idle}")
    private Integer maxIdle;
    @Value("${jedis.max.waitmillis}")
    private Long maxWaitMillis;



    public  JedisConfiguration() { }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(Integer maxTotal) {
        this.maxTotal = maxTotal;
    }

    public Integer getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(Integer maxIdle) {
        this.maxIdle = maxIdle;
    }

    public Long getMaxWaitMillis() {
        return maxWaitMillis;
    }

    public void setMaxWaitMillis(Long maxWaitMillis) {
        this.maxWaitMillis = maxWaitMillis;
    }
}
