package com.cors.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cors.core.dao.OrgnizationRepository;
import com.cors.core.entity.Orgnization;
import com.cors.core.service.IOrgnizationService;

@Service("orgnizationService")
public class OrgnizationService implements IOrgnizationService {
	
	@Resource
	private OrgnizationRepository orgnizationRepository;

	@Override
	public Orgnization add(Orgnization orgnization) {
		return orgnizationRepository.save(orgnization);
	}

	@Override
	public List<Orgnization> findAll() {
		return orgnizationRepository.findAll();
	}

	@Override
	public void delete(int id) {
		orgnizationRepository.delete(id);
	}

	@Override
	public Orgnization findById(int id) {
		return orgnizationRepository.findOne(id);
	}

	@Override
	public void update(Orgnization orgnization) {
		orgnizationRepository.save(orgnization);
	}

	@Override
	public List<Orgnization>findByName(String name) {
		return orgnizationRepository.findByName(name);
	}
	
	

}
