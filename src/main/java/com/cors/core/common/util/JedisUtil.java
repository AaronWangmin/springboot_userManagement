package com.cors.core.common.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil {
	static Log logger = LogFactory.getLog(JedisUtil.class);
	
	private static Jedis jedis = null;
	private static JedisPool jedisPool = null;
	
	private JedisUtil() {}
	
	public static Jedis getRedis() {
		
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(1000);	// 设置最大连接数
		config.setMaxIdle(100);		// 设置最大空闲数
		config.setMaxWaitMillis(10000);
				
		jedisPool = new JedisPool(config,"192.168.5.193",6379);
		
		jedis = jedisPool.getResource();
		
		jedis.auth("wm800421WM");
		
		return jedis;
	}
	
	public static void close() {
		if(jedis !=null) {
			jedis.close();
			jedisPool.close();
		}
	}
	
}
