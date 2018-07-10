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
import com.cors.core.entity.MountPoint;
import com.cors.core.service.IMountPointService;

import redis.clients.jedis.Jedis;

@Component
public class MountPointsRedisHolder {
	@Resource
	private IMountPointService mountPointService; 
	
	private static final String hkey = "mountPoints";
	
	public void sendAll2Redis() {
		
		List<MountPoint> mountPoints = mountPointService.findAll();
		
		Jedis jedis = JedisUtil.getRedis();
		
		// 删除 redis中已有的 mountPoints
		deleteHashMap(jedis, hkey);
		
		// 重新设置 mountPoint 
		for(MountPoint mp : mountPoints) {
			byte[] key = mp.getName().getBytes();
			byte[] value = SerializeUtil.serialize(mp);
			
			jedis.hset(hkey.getBytes(), key, value);
		}
		
		JedisUtil.close();
		
	}
	
	public List<MountPoint> getAll(){
		Jedis jedis = JedisUtil.getRedis();
		
		List<MountPoint> mountPoints = new ArrayList<MountPoint>();
		
		Map<byte[],byte[]> map = jedis.hgetAll(hkey.getBytes());
		for(Entry<byte[], byte[]> entry : map.entrySet()) {
			MountPoint mp = (MountPoint)SerializeUtil.unSerialize(entry.getValue());
			mountPoints.add(mp);
		}
		
		JedisUtil.close();
		
		return mountPoints;
	}
	
	public Map<String,MountPoint> getAll2() {
		Jedis jedis = JedisUtil.getRedis();
		
		Map<String,MountPoint> mps = new HashMap<String,MountPoint>();
		
		Map<byte[],byte[]> map = jedis.hgetAll(hkey.getBytes());
		
		for(Entry<byte[], byte[]> entry : map.entrySet()) {
			MountPoint value = (MountPoint)SerializeUtil.unSerialize(entry.getValue());
			String key = value.getName();
			mps.put(key, value);
		}
		
		JedisUtil.close();
		
		return mps;
	}
	
	// 应为更新，而不是清除
	// TODO
	public void deleteHashMap(Jedis jedis,String key) {
		if(jedis.hgetAll(hkey.getBytes()) !=null) jedis.del(hkey);
	}
	
	

}
