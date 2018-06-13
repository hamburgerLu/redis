package com.example.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by lu on 2018/6/6.
 */
@Component
public class RedisHashUtil {
    @Autowired
    private JedisPool jedisPool;

    private Jedis jedis;


    /**
     * HMGET命令，从hashKey中得到，一个或多个键的值
     * @param key
     * @param fields
     * @return
     */
    public List<String> hmget(String key , String ... fields){
        jedis = jedisPool.getResource();
        return jedis.hmget(key,fields);
    }


    /**
     * HMSET命令，为散列key里面一个或多个键设置值
     * @param key
     * @param hash
     * @return Return OK or Exception if hash is empty
     */
    public String hmset(String key, Map<String,String> hash){
        jedis = jedisPool.getResource();
        return jedis.hmset(key,hash);
    }


    /**
     * HDEL命令，批量删除key中的fields，返回删除的个数
     * @param key
     * @param fields
     * @return
     */
    public Long hdel(String key, String ... fields){
        jedis = jedisPool.getResource();
        return jedis.hdel(key,fields);
    }


    /**
     * HLEN命令，返回散列key中的元素的个数
     * @param key
     * @return
     */
    public Long hlen(String key){
        jedis = jedisPool.getResource();
        return jedis.hlen(key);
    }


    /**
     * HEXISTS命令，检查给定的键是否存在于散列中
     * @param key
     * @param field
     * @return
     */
    public Boolean hexists(String key, String field){
        jedis = jedisPool.getResource();
        return jedis.hexists(key,field);
    }

    /**
     * HKEYS命令，获取散列包含的所有的键
     * @param key
     * @return
     */
    public Set<String> hkeys(String key){
        jedis = jedisPool.getResource();
        return jedis.hkeys(key);
    }

    /**
     * HVALS命令，获取散列包含的所有的值
     * @param key
     * @return
     */
    public List<String> hvals(String key){
        jedis = jedisPool.getResource();
        return jedis.hvals(key);
    }

    /**
     * HGETALL命令，获取散列包含的所有的键值对
     * @param key
     * @return
     */
    public Map<String, String> hgetAll(String key){
        jedis = jedisPool.getResource();
        return jedis.hgetAll(key);
    }

    /**
     * HINCRBY命令，将键field存储的值加上整数value
     * @param key
     * @param field
     * @param value
     * @return
     */
    public Long hincrby(String key, String field, Long value){
        jedis = jedisPool.getResource();
        return jedis.hincrBy(key,field,value);
    }

    /**
     * HINCRBYFLOAT命令，将键field存储的值加上整数value
     * @param key
     * @param field
     * @param value
     * @return
     */
    public Double hincrByFloat(String key, String field, Double value){
        jedis = jedisPool.getResource();
        return jedis.hincrByFloat(key,field,value);
    }
}
