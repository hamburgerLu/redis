package com.example.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ZParams;
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

    /**
     * ZREVRANK命令，返回有序集合key中的member的排名（默认从大到小排列）
     * @param key
     * @param member
     * @return
     */
    public Long zrevrank(String key, String member){
        jedis = jedisPool.getResource();
        return jedis.zrevrank(key,member);
    }

    /**
     * ZREVRANGE命令，返回有序集合给定排名范围内的成员，默认按照从大到小排列
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Set<String> zrevrange(String key, long start, long end){
        jedis = jedisPool.getResource();
        return jedis.zrevrange(key,start,end);
    }


    /**
     * zrangeByScore命令，有四种方式：
     * 1、返回有序集合中分值介于min和max之间的成员
     * @param key
     * @param min
     * @param max
     * @return
     */
    public Set<String> zrangeByScore(String key, double min, double max){
        jedis = jedisPool.getResource();
        return jedis.zrangeByScore(key,min,max);
    }

    /**
     * 2、返回有序集合中成员名字介于min和max之间的成员
     * @param key
     * @param min
     * @param max
     * @return
     */
    public Set<String> zrangeByScore(String key, String min, String max){
        jedis = jedisPool.getResource();
        return jedis.zrangeByScore(key,min,max);
    }

    /**
     * 3、返回有序集合中分值介于min和max之间的成员，从offset开始，数count个
     * @param key
     * @param min
     * @param max
     * @param offset
     * @param count
     * @return
     */
    public Set<String> zrangeByScore(String key, double min, double max, int offset, int count) {
        jedis = jedisPool.getResource();
        return jedis.zrangeByScore(key,min,max,offset,count);
    }

    /**
     * 4、返回有序集合中成员名字介于min和max之间的成员，从offset开始，数count个
     * @param key
     * @param min
     * @param max
     * @param offset
     * @param count
     * @return
     */
    public Set<String> zrangeByScore(String key, String min, String max, int offset, int count){
        jedis = jedisPool.getResource();
        return jedis.zrangeByScore(key,min,max,offset,count);
    }



    /**
     * zrevrangeByScore命令，有四种方式：
     * 1、返回有序集合中分值介于min和max之间的成员，并按照分值从大到小返回他们
     * @param key
     * @param min
     * @param max
     * @return
     */
    public Set<String> zrevrangeByScore(String key, double min, double max){
        jedis = jedisPool.getResource();
        return jedis.zrevrangeByScore(key,min,max);
    }

    /**
     * 2、返回有序集合中成员名字介于min和max之间的成员，并按照分值从大到小返回他们
     * @param key
     * @param min
     * @param max
     * @return
     */
    public Set<String> zrevrangeByScore(String key, String min, String max){
        jedis = jedisPool.getResource();
        return jedis.zrevrangeByScore(key,min,max);
    }

    /**
     * 3、返回有序集合中分值介于min和max之间的成员，从offset开始，数count个，并按照分值从大到小返回他们
     * @param key
     * @param min
     * @param max
     * @param offset
     * @param count
     * @return
     */
    public Set<String> zrevrangeByScore(String key, double min, double max, int offset, int count) {
        jedis = jedisPool.getResource();
        return jedis.zrevrangeByScore(key,min,max,offset,count);
    }

    /**
     * 4、返回有序集合中成员名字介于min和max之间的成员，从offset开始，数count个，并按照分值从大到小返回他们
     * @param key
     * @param min
     * @param max
     * @param offset
     * @param count
     * @return
     */
    public Set<String> zrevrangeByScore(String key, String min, String max, int offset, int count){
        jedis = jedisPool.getResource();
        return jedis.zrevrangeByScore(key,min,max,offset,count);
    }


    /**
     * 移除所有的有序集合中的排名介于start和end之间的成员
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Long zremrangeByRank(String key, long start, long end){
        jedis = jedisPool.getResource();
        return jedis.zremrangeByRank(key,start,end);
    }


    /**
     * zremrangeByScore命令，有两种
     * 1、移除分值介于min和max之间的成员
     * @param key
     * @param min
     * @param max
     * @return
     */
    public Long zremrangeByScore(String key, double min, double max){
        jedis = jedisPool.getResource();
        return jedis.zremrangeByScore(key,min,max);
    }

    /**
     *  2、移除成员介于min和max之间的成员
     * @param key
     * @param min
     * @param max
     * @return
     */
    public Long zremrangeByScore(String key, String min, String max){
        jedis = jedisPool.getResource();
        return jedis.zremrangeByScore(key,min,max);
    }


    /**
     * 类似于集合中的交集运算，把sets中共有的成员的分值相加然后存入destkey中
     * @param dstkey
     * @param sets
     * @return
     */
    public Long zinterStore(String dstkey, String... sets){
        jedis = jedisPool.getResource();
        return jedis.zinterstore(dstkey,sets);
    }
    /**
     * 指定了对于相同成员的操作，（最大，最小，求和）
     * @param dstkey
     * @param params
     * @param sets
     * @return
     */
    public Long zinterStore(String dstkey, ZParams params, String... sets){
        jedis = jedisPool.getResource();
        return jedis.zinterstore(dstkey,params,sets);
    }

    /**
     * 类似于集合中的并集运算，把sets中共有的成员的分值相加然后存入destkey中
     * @param dstkey
     * @param sets
     * @return
     */
    public Long zunionstore(String dstkey, String... sets){
        jedis = jedisPool.getResource();
        return jedis.zunionstore(dstkey,sets);
    }
    /**
     * 指定了对于相同成员的操作，（最大，最小，求和）
     * @param dstkey
     * @param sets
     * @return
     */
    public Long zunionstore(String dstkey,ZParams params, String... sets){
        jedis = jedisPool.getResource();
        return jedis.zunionstore(dstkey,params,sets);
    }


}
