package com.cors.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cors.web.entity.MountPoint;

/**
 * @author Wangmin@shbeidou.com *
 * @data   2018年5月31日
 */
public interface MountPointRepository extends JpaRepository<MountPoint, Integer> {
	
	public List<MountPoint> findByName(String name);

}
