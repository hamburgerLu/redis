package com.example.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.sortedset.ZAddParams;
import redis.clients.jedis.params.sortedset.ZIncrByParams;

import java.util.Map;
import java.util.Set;

/**
 * Created by lu on 2018/6/6.
 */
@Component
public class RedisZSetUtil {

    @Autowired
    private JedisPool jedisPool;

    private Jedis jedis;


    /**
     * zadd包含了四种方式
     * 1、把带有分值score的member插入到有序集合key里面
     * @return
     */
    public Long zadd(String key, double score, String member){
        jedis = jedisPool.getResource();
        return jedis.zadd(key,score,member);
    }
    /**
     * 2、把带有分值score的member的Map插入到有序集合key里面
     * @param key
     * @param scoreMembers
     * @return
     */
    public Long zadd(String key, Map<String, Double> scoreMembers){
        jedis = jedisPool.getResource();
        return jedis.zadd(key,scoreMembers);
    }
    /**
     * 3、把带有分值score的member插入到有序集合key里面，按照params的方式(TODO：有问题)
     * @param key
     * @param score
     * @param member
     * @param params
     * @return
     */
    public Long zadd(String key, double score, String member, ZAddParams params){
        jedis = jedisPool.getResource();
        return jedis.zadd(key,score,member,params);
    }
    /**
     * 4、把带有分值score的member的Map插入到有序集合key里面，按照params的方式(TODO：有问题)
     * @param key
     * @param scoreMembers
     * @param params
     * @return
     */
    public Long zadd(String key, Map<String, Double> scoreMembers, ZAddParams params){
        jedis = jedisPool.getResource();
        return jedis.zadd(key,scoreMembers,params);
    }

    /**
     * ZREM命令，从key的有序集合里面删除一个或多个menber，返回移除的数量
     * @param key
     * @param member
     * @return
     */
    public Long zrem(String key, String... member){
        jedis = jedisPool.getResource();
        return jedis.zrem(key,member);
    }

    /**
     * ZCARD命令，返回有序集合key中包含的元素的个数
     * @param key
     * @return
     */
    public Long zcard(String key){
        jedis = jedisPool.getResource();
        return jedis.zcard(key);
    }


    /**
     * zincrby命令，有两种用法：
     * 1、给有序集合key的member成员的分值上加上score
     * @param key
     * @param score
     * @param member
     * @return
     */
    public Double zincrby(String key, double score, String member){
        jedis = jedisPool.getResource();
        return jedis.zincrby(key,score,member);

    }
    /**
     * 2、给有序集合key的member成员的分值上加上score，已params的方式
     * @param key
     * @param score
     * @param member
     * @param params
     * @return
     */
    public Double zincrby(String key, double score, String member, ZIncrByParams params){
        jedis = jedisPool.getResource();
        return jedis.zincrby(key,score,member,params);

    }

    /**
     * zount命令，返回min和max之间的元素的个数，有两种方式
     * 1、直接用分值的范围；
     * 2、用成员的名字的获取分值的范围；
     * @param key
     * @param min
     * @param max
     * @return
     */
    public Long zcount(String key, double min, double max){
        jedis = jedisPool.getResource();
        return jedis.zcount(key,min,max);
    }
    public Long zcount(String key, String min, String max){
        jedis = jedisPool.getResource();
        return jedis.zcount(key,min,max);
    }

    /**
     * ZRAK命令，获取menber成员在有序集合中的排名
     * @param key
     * @param member
     * @return
     */
    public Long zrank(String key, String member){
        jedis = jedisPool.getResource();
        return jedis.zrank(key,member);
    }

    /**
     * ZSCORE命令，返回成员menber的分值
     * @param key
     * @param member
     * @return
     */
    public Double zscore(String key, String member){
        jedis = jedisPool.getResource();
        return jedis.zscore(key,member);
    }

    /**
     * ZRANGE命令，返回有序集合中的排名介于start和end之间的成员
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Set<String> zrange(String key, long start, long end){
        jedis = jedisPool.getResource();
        return jedis.zrange(key,start,end);
    }






}
