package com.cors.core.redis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.cors.core.common.util.JedisUtil;
import com.cors.core.common.util.SerializeUtil;
import com.cors.core.entity.ReferenceStation;
import com.cors.core.service.IReferenceStationService;

import redis.clients.jedis.Jedis;

@Component
public class ReferenceStationsRedisHolder {
	@Resource
	private IReferenceStationService referenceStationService; 
	
	private static final String hkey = "referenceStations";
	
	public void sendAll2Redis() {
		
		List<ReferenceStation> referenceStations = referenceStationService.findAll();
		
		Jedis jedis = JedisUtil.getRedis();
		
		deleteHashMap(jedis,hkey);
		
		for(ReferenceStation rs : referenceStations) {
			byte[] key = rs.getName().getBytes();
			byte[] value = SerializeUtil.serialize(rs);
			
			jedis.hset(hkey.getBytes(), key, value);
		}
		
		JedisUtil.close();
		
	}
	
	public List<ReferenceStation> getAll(){
		Jedis jedis = JedisUtil.getRedis();
		
		List<ReferenceStation> referenceStations = new ArrayList<ReferenceStation>();
		
		Map<byte[],byte[]> map = jedis.hgetAll(hkey.getBytes());
		for(Entry<byte[], byte[]> entry : map.entrySet()) {
			ReferenceStation rs = (ReferenceStation)SerializeUtil.unSerialize(entry.getValue());
			referenceStations.add(rs);
		}
		
		JedisUtil.close();
		
		return referenceStations;
	}
	
	public Map<String,ReferenceStation> getAll2() {
		Jedis jedis = JedisUtil.getRedis();
		
		Map<String,ReferenceStation> rss = new HashMap<String,ReferenceStation>();
		
		Map<byte[],byte[]> map = jedis.hgetAll(hkey.getBytes());
		
		for(Entry<byte[], byte[]> entry : map.entrySet()) {
			ReferenceStation value = (ReferenceStation)SerializeUtil.unSerialize(entry.getValue());
			String key = value.getName();
			rss.put(key, value);
		}
		
		JedisUtil.close();
		
		return rss;
	}
	
	// 应为更新，而不是清除
	// TODO
	public void deleteHashMap(Jedis jedis,String key) {
		if(jedis.hgetAll(hkey.getBytes()) !=null) jedis.del(hkey);
	}

}
