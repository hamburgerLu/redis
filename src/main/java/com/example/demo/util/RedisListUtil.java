package com.example.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * Created by lu on 2018/6/6.
 */
@Component
public class RedisListUtil {
    @Autowired
    private JedisPool jedisPool;

    private Jedis jedis;

    /**
     * rpush命令，将string推入key对应的列表的右侧
     * @param key
     * @param string
     * @return
     */
    public Long rpush(String key,String ... string){
        jedis = jedisPool.getResource();
        return jedis.rpush(key,string);
    }

    /**
     * lpush命令，将string推入key对应的列表的左侧
     * @param key
     * @param string
     * @return
     */
    public Long lpush(String key,String ... string){
        jedis = jedisPool.getResource();
        return jedis.lpush(key,string);
    }

    /**
     * rpop命令，移除并返回列表最右侧的元素
     * @param key
     * @return
     */
    public String rpop(String key){
        jedis = jedisPool.getResource();
        return jedis.rpop(key);
    }

    /**
     * lpop命令，移除并返回列表最左侧的元素
     * @param key
     * @return
     */
    public String lpop(String key){
        jedis = jedisPool.getResource();
        return jedis.lpop(key);
    }

    /**
     * lindex命令，返回列表中第index个元素
     * @param key
     * @param index
     * @return
     */
    public String lindex(String key, long index){
        jedis = jedisPool.getResource();
        return jedis.lindex(key,index);
    }

    /**
     * lrange命令，获取列表中的偏移量在start和end之间的值的list，其中start和end在内的元素也会被包含在内
     * @param key
     * @param start
     * @param end
     * @return
     */
    public List<String> lrange(String key, long start, long end){
        jedis = jedisPool.getResource();
        return jedis.lrange(key,start,end);
    }

    /**
     * ltrim命令，裁剪key对应的list，并且返回结果码（Status code reply）
     * @param key
     * @param start
     * @param end
     * @return
     */
    public String ltrim(String key, long start, long end){
        jedis = jedisPool.getResource();
        return jedis.ltrim(key,start,end);
    }


    /**
     * blpop命令
     * @param timeout
     * @param keys
     * @return
     */
    public List<String> blpop(int timeout, String... keys){
        jedis = jedisPool.getResource();
        return jedis.blpop(timeout, keys);
    }

    /**
     * brpop
     * @param timeout
     * @param keys
     * @return
     */
    public List<String> brpop(int timeout, String... keys){
        jedis = jedisPool.getResource();
        return jedis.brpop(timeout, keys);
    }

    /**
     * rpoplpush
     * @param srckey
     * @param dstkey
     * @return
     */
    public String rpoplpush(String srckey, String dstkey){
        jedis = jedisPool.getResource();
        return jedis.rpoplpush(srckey,dstkey);
    }

    /**
     * brpoplpush
     * @param source
     * @param destination
     * @param timeout
     * @return
     */
    public String brpoplpush(String source, String destination, int timeout){
        jedis = jedisPool.getResource();
        return jedis.brpoplpush(source,destination,timeout);
    }

}
