package com.cors.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cors.core.dao.MountPointRepository;
import com.cors.core.entity.MountPoint;
import com.cors.core.service.IMountPointService;

@Service("mountPointService")
public class MountPointService implements IMountPointService {
	
	@Resource
	private MountPointRepository mountPointRepository;

	@Override
	public MountPoint add(MountPoint mountPoint) {
		return mountPointRepository.save(mountPoint);
	}

	@Override
	public List<MountPoint> findAll() {
		return mountPointRepository.findAll();
	}

	@Override
	public void delete(int id) {
		mountPointRepository.delete(id);
	}

	@Override
	public MountPoint findById(int id) {
		return mountPointRepository.findOne(id);
	}

	@Override
	public void update(MountPoint mountPoint) {
		mountPointRepository.save(mountPoint);
	}

	@Override
	public List<MountPoint>findByName(String name) {
		return mountPointRepository.findByName(name);
	}
	
	

}
