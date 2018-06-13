package com.example.demo;

import com.example.demo.util.RedisKeyUtil;
import com.example.demo.util.RedisSetUtil;
import com.example.demo.util.RedisZSetUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.sortedset.ZAddParams;

import java.util.HashMap;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {

	@Autowired
	private RedisKeyUtil redisKeyUtil;

	@Autowired
	private RedisSetUtil redisSetUtil;

	@Autowired
	private RedisZSetUtil redisZSetUtil;

	@Autowired
	private JedisPool jedisPool;

	private Jedis jedis;


	@Test
	public void contextLoads() {
		String KEY = "myzset";
		String key1 = "key1";
		double score1 = 20;
		Map<String, Double> map = new HashMap<String, Double>(){{
			put(key1, score1);
			put("key2", 20d);
			put("key3", 30d);
			put("key4", 40d);
			put("key5", 50d);
			put("key6", 60d);
		}};

//		long size = redisZSetUtil.zadd(KEY, 20, key1);
//		System.out.println("size = "+size);
//
//		//有相同的Key时不会做插入，会做更新
//		size = redisZSetUtil.zadd(KEY, 30, key1);
//		System.out.println("size = "+size);
//
//		//插入多个元素
//		size = redisZSetUtil.zadd(KEY, map);
//		System.out.println("size = "+size);
//
//		System.out.println("到现在为止，myzset里面有的元素应该有"+redisZSetUtil.zcard(KEY)+"个");

		jedis = jedisPool.getResource();
		long size = jedis.zadd(KEY, map);
		System.out.println("size = "+size);
		//指定参数ZAddParams, 经过上面的运行key1对应的score为20
//		ZAddParams zp1 = ZAddParams.zAddParams();
//		//nx表示如果key1不存在则插入，所以下面score为20，没有变为30
//		zp1.nx();
//		jedis.zadd(KEY, 30, key1, zp1);
//		double score11 = jedis.zscore(KEY, key1);
//		System.out.println("在进行了nx操作后，score的值为："+score11);


		//指定参数ZAddParams, 经过上面的运行key1对应的score为20
		ZAddParams zp2 = ZAddParams.zAddParams();
		//xx表示如果key存在才作插入(更新)，否则不做插入
		zp2.xx();
		redisZSetUtil.zadd(KEY, 30, "1234", zp2);
		//不存在，为空,表示上面的语句没有做插入
		//如果使用语句double score来接收结果，会抛出NPE
		//如果是double score声明记得在Test上面加上(expected = NullPointerException.class)
		Double score12 = redisZSetUtil.zscore(KEY, "1234");
		System.out.println("在进行了xx操作后，score的值为："+score12);


		//指定参数ZAddParams, 经过上面的运行key1对应的score为20
		ZAddParams zp3 = ZAddParams.zAddParams();
		//ch表示返回被修改的元素个数
		zp3.ch();
		//score被更新
		size = redisZSetUtil.zadd(KEY, 50, key1, zp3);
		System.out.println("size = "+size);

		//返回0，既没有更新score，也没有插入
		size = redisZSetUtil.zadd(KEY, 50, key1, zp3);
		System.out.println("size = "+size);

		//插入新元素
		size = redisZSetUtil.zadd(KEY, 50, "12345", zp3);
		System.out.println("size = "+size);

		System.out.println("到现在为止，myzset里面有的元素应该有"+redisZSetUtil.zcard(KEY)+"个");




	}

}
