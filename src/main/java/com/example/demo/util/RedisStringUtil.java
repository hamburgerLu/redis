package com.example.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 字符串可以存储一下类型的值
 * 1、字符串（byte String）
 * 2、整数
 * 3、浮点数
 *
 * Created by lu on 2018/6/6.
 */
@Component
public class RedisStringUtil {

    @Autowired
    private JedisPool jedisPool;

    private Jedis jedis;

    /**
     * incr命令，可以在已有值的基础上自增1
     * @param key
     * @return
     */
    public Long incr(String key){
        jedis = jedisPool.getResource();
        return jedis.incr(key);
    }

    /**
     * incrBy命令，可以在已有值的基础上自增integer，注意这里必须是long类型的，可能会导致redis的序列化的问题。
     * @param key
     * @param integer
     * @return
     */
    public Long incrBy(String key,long integer){
        jedis = jedisPool.getResource();
        return jedis.incrBy(key,integer);
    }

    /**
     * decr命令，可以在已有值的基础上自减1
     * @param key
     * @return
     */
    public Long decr(String key){
        jedis = jedisPool.getResource();
        return jedis.decr(key);
    }

    /**
     * decrBy命令，可以在已有值的基础上自减integer，注意这里必须是long类型的，可能会导致redis的序列化的问题。
     * @param key
     * @param integer
     * @return
     */
    public Long decrBy(String key,long integer){
        jedis = jedisPool.getResource();
        return jedis.decrBy(key,integer);
    }

    /**
     * incrByFloat命令，可以在已有值的基础上加上value
     * 注意，这里没有decrByFloat命令，可以给value赋值负数来实现
     * @param key
     * @param value
     * @return
     */
    public Double incrByFloat(String key,double value){
        jedis = jedisPool.getResource();
        return jedis.incrByFloat(key,value);
    }


    /**
     * append命令，在指定的key上追加一段字符串
     * @param key
     * @param value
     * @return 返回为结束后的字符串的长度
     */
    public Long append(String key , String value){
        jedis = jedisPool.getResource();
        return jedis.append(key,value);
    }

    /**
     * getrange命令，截取部分字符串，包括startOffset和endOffset在内的
     * @param key
     * @param startOffset
     * @param endOffset
     * @return
     */
    public String getrange(String key, long startOffset, long endOffset){
        jedis = jedisPool.getResource();
        return jedis.getrange(key,startOffset,endOffset);
    }

    /**
     * setrange命令，将key对应的字符串，从offset偏移量开始，之后的设置为定植value
     * @param key
     * @param offset
     * @param value
     * @return
     */
    public Long setrange(String key, long offset, String value){
        jedis = jedisPool.getResource();
        return jedis.setrange(key,offset,value);
    }


}
