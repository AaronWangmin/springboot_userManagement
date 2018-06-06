package com.cors.web.redis;

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
import com.cors.web.entity.ReferenceStation;

@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！ 
@SpringBootTest(classes = SpringbootMain.class)
@EnableAutoConfiguration
public class TestReferenceStationsRedisHolder {
	@Resource
	ReferenceStationsRedisHolder holder;

	@Test
	public void sendAll2Redis() {
		holder.sendAll2Redis();
	}
	
	@Test
	public void getAll() {
		
		List<ReferenceStation> rss = holder.getAll();
		for(ReferenceStation rs : rss) {
			System.out.println("from redis............." + rs.getName());
		}
	}
	
	@Test
	public void getAll2() {
		
		 Map<String,ReferenceStation> rss = holder.getAll2();
		for(Entry<String,ReferenceStation> entry  : rss.entrySet()) {
			System.out.println("from redis............." + entry.getKey() + " : " + entry.getValue().getName());
		}
	}

}
