package com.example.demo.config;

import com.example.demo.util.JedisConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lu on 2018/6/6.
 */
@Configuration
public class SpringConfig {

    @Autowired
    private JedisConfiguration jedisConfiguration;

    @Bean
    public ShardedJedisPool shardedJedisPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(jedisConfiguration.getMaxTotal());
        jedisPoolConfig.setMaxIdle(jedisConfiguration.getMaxIdle());
        jedisPoolConfig.setMaxWaitMillis(jedisConfiguration.getMaxWaitMillis());
        List<JedisShardInfo> jedisShardInfos = new ArrayList<>();
        jedisShardInfos.add(new JedisShardInfo(jedisConfiguration.getHost(),jedisConfiguration.getPort(),"master"));

        return new ShardedJedisPool(jedisPoolConfig, jedisShardInfos);
    }


    @Bean
    public JedisPool jedisPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(jedisConfiguration.getMaxTotal());
        jedisPoolConfig.setMaxIdle(jedisConfiguration.getMaxIdle());
        jedisPoolConfig.setMaxWaitMillis(jedisConfiguration.getMaxWaitMillis());

        return new JedisPool(jedisPoolConfig,jedisConfiguration.getHost(), jedisConfiguration.getPort());
    }
}
