package com.cors.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cors.web.dao.OrgnizationRepository;
import com.cors.web.entity.Orgnization;
import com.cors.web.service.IOrgnizationService;

@Service("orgnizationService")
public class OrgnizationService implements IOrgnizationService {
	
	@Resource
	OrgnizationRepository orgnizationRepository;

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
