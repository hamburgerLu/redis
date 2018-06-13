package com.example.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

/**
 * Created by lu on 2018/6/6.
 */
@Component
public class RedisKeyUtil {

    @Autowired
    private JedisPool jedisPool;

    private Jedis jedis;

    /**
     * 得到所有的key
     * @return
     */
    public Set<String> keys(){
        jedis = jedisPool.getResource();
        return jedis.keys("*");
    }

}
