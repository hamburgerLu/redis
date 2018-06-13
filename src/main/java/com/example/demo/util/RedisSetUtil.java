package com.example.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Set;

/**
 * Created by lu on 2018/6/6.
 */
@Component
public class RedisSetUtil {

    @Autowired
    private JedisPool jedisPool;

    private Jedis jedis;


    /**
     * SADD命令，将一个或多个元素添加到集合里面
     * 暂时只支持对String的操作
     * @param key
     * @param strs
     *
     * @return 返回成功的条数
     */
    public Long sadd(String key,String ... strs){
        jedis = jedisPool.getResource();
        return jedis.sadd(key, strs);
    }


    /**
     * SREM命令，将一个或多个元素从集合里面移除
     * 暂时只支持对String的操作
     * @param key
     * @param strs
     * @return 返回成功的条数
     */
    public Long srem(String key,String ... strs){
        jedis = jedisPool.getResource();
        return jedis.srem(key, strs);
    }

    /**
     * SISMEMBER命令，查询item是否存在于集合key里面
     * @param key
     * @param item
     * @return
     */
    public Boolean sismember(String key,String item){
        jedis = jedisPool.getResource();
        return jedis.sismember(key,item);
    }


    /**
     * SCARD命令，查询key所在的集合里面的元素的数量
     * @param key
     * @return
     */
    public Long scard(String key){
        jedis = jedisPool.getResource();
        return jedis.scard(key);
    }


    /**
     * SMEMBERS命令，返回集合包含的所有元素
     * @param key
     * @return
     */
    public Set<String> smembers(String key){
        jedis = jedisPool.getResource();
        return jedis.smembers(key);
    }

    /**
     * SRANDMEMBER命令，从集合里取出count个元素
     * 当count为正数时，返回的随机元素不会重复
     * 当count为负数时，返回的随机元素可能会重合
     * @param key
     * @param count
     * @return
     */
    public List<String> srandmember(String key,Integer count){
        jedis = jedisPool.getResource();
        return jedis.srandmember(key,count);
    }

    /**
     * SPOP命令，随机从集合里移除1个元素，并返回移除的元素
     * @param key
     * @return
     */
    public String spop(String key){
        jedis = jedisPool.getResource();
        return jedis.spop(key);
    }

    /**
     * SPOP命令，随机从集合里移除count个元素，并返回移除元素的set
     * @param key
     * @param count
     * @return
     */
    public Set<String> spop(String key, Long count){
        jedis = jedisPool.getResource();
        return jedis.spop(key,count);
    }

    /**
     * SMOVE命令，如果sourceKey中包含元素item，则从sourceKey中移除item，并把item放入destKey中
     * 如果item被成功移除，则返回1，否则返回0
     * @param sourceKey
     * @param destKey
     * @param item
     * @return
     */
    public Long smove(String sourceKey,String destKey, String item){
        jedis = jedisPool.getResource();
        return jedis.smove(sourceKey,destKey,item);
    }


    /**
     * SDIFF命令，返回那些存在于keys中的第一个key内，但不存在于其他集合中的元素
     * 数学上的差集
     * @param keys
     * @return
     */
    public Set<String> sdiff(String ... keys){
        jedis = jedisPool.getResource();
        return jedis.sdiff(keys);
    }

    /**
     * SDIFFSTORE命令，将那些存在于keys中的第一个key内，但不存在于其他集合中的元素，存储到destKey内
     * 成功返回1，失败返回0
     * 数学上的差集
     * @param destKey
     * @param keys
     * @return
     */
    public Long sdiffstore(String destKey,String ... keys){
        jedis = jedisPool.getResource();
        return jedis.sdiffstore(destKey,keys);
    }


    /**
     * SINTER命令，返回keys中所有key共同存在的元素
     * 数学上的交集
     * @param keys
     */
    public Set<String> sinter(String ... keys){
        jedis = jedisPool.getResource();
        return jedis.sinter(keys);
    }

    /**
     * SINTERSTORE命令，将那些keys中所有key共同存在的元素，存储到destKey内
     * 成功返回1，失败返回0
     * 数学上的交集
     * @param destKey
     * @param keys
     * @return
     */
    public Long sinterstore(String destKey,String ... keys){
        jedis = jedisPool.getResource();
        return jedis.sinterstore(destKey,keys);
    }

    /**
     * SUNION命令，返回keys中的所有的至少存在于一个集合中的元素
     * 数学上的并集
     * @param keys
     * @return
     */
    public Set<String> sunion(String ... keys){
        jedis = jedisPool.getResource();
        return jedis.sunion(keys);
    }


    /**
     * SUNIONSTORE命令，将那些keys中的所有的至少存在于一个集合中的元素，存储到destKey内
     * 成功返回1，失败返回0
     * 数学上的并集
     * @param keys
     * @return
     */
    public Long sunionstore(String destKey,String ... keys){
        jedis = jedisPool.getResource();
        return jedis.sunionstore(destKey,keys);
    }



}
