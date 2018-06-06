package com.cors.web.service;

import java.util.List;

import com.cors.web.entity.MountPoint;

/**
 * @author Wangmin@shbeidou.com *
 * @data   2018年5月31日
 */
public interface IMountPointService {
	public MountPoint add(MountPoint mountPoint);
	public void delete(int id);
	public void update(MountPoint mountPoint);
	public List<MountPoint> findAll();
	public MountPoint findById(int id);
	public List<MountPoint> findByName(String name);

}
