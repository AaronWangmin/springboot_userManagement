package com.cors.web.service.impl;

import java.util.List;

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
public class TestMountPointService {
	
	@Resource
	MountPointService mountPointService;

	@Test
	public void testFindAll() {
		List<MountPoint> mps = mountPointService.findAll();
//		System.out.println(mps.size());
	}
	

}
