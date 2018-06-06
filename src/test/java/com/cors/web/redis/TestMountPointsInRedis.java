package com.cors.web.redis;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cors.SpringbootMain;
import com.cors.web.entity.MountPoint;

@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！ 
@SpringBootTest(classes = SpringbootMain.class)
@EnableAutoConfiguration
public class TestMountPointsInRedis {
	@Resource
	MountPointsRedisHolder holder;

	@Test
	public void sendAll2Redis() {
//		MountPointsInRedis mpr = new MountPointsInRedis();
		
		holder.sendAll2Redis();
	}
	
	@Test
	public void getAll() {
		
		List<MountPoint> mps = holder.getAll();
		for(MountPoint mp : mps) {
			System.out.println("from redis............." + mp.getName());
		}
	}
	
	@Test
	public void getAll2() {
		
		 Map<String,MountPoint> mps = holder.getAll2();
		for(Entry<String,MountPoint> entry  : mps.entrySet()) {
			System.out.println("from redis............." + entry.getKey() + " : " + entry.getValue().getName());
		}
	}

}
