package com.cors.web.schedul;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cors.web.redis.MountPointsRedisHolder;
import com.cors.web.redis.ReferenceStationsRedisHolder;

@Component
public class RefreshRedisSchedul {
	private final Logger logger = LoggerFactory.getLogger(RefreshRedisSchedul.class);
	
	@Resource
	MountPointsRedisHolder mountPointsRedisHolder;
	
	@Resource
	ReferenceStationsRedisHolder referenceStationsHolder;
	
	@Scheduled(cron="0 0/2 8-20 * * ?")
	public void refreshMountPoint(){
		mountPointsRedisHolder.sendAll2Redis();
		logger.info("refresh the mountPoints.");
	}
	
	@Scheduled(cron="0 0/4 8-20 * * ?")
	public void refreshReferenceStaion(){
		referenceStationsHolder.sendAll2Redis();
		logger.info("refresh the referenceStations.");
	}
	

}
