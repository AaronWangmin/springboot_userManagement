package com.cors.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cors.core.dao.OrgnizationRepository;
import com.cors.core.dao.ReferenceStationRepository;
import com.cors.core.entity.Orgnization;
import com.cors.core.entity.ReferenceStation;
import com.cors.core.service.IReferenceStationService;

@Service("referenceStationService")
public class ReferenceStationService implements IReferenceStationService {
	
	@Resource
	private ReferenceStationRepository referenceStationRepository;
	
	@Resource
	private OrgnizationRepository orgnizationRepository;
	
	@Override
	public ReferenceStation add(ReferenceStation referenceStation) {
		return referenceStationRepository.save(referenceStation);
	}
	
	@Override
	public ReferenceStation add(ReferenceStation referenceStation, int orgnizationId) {
		Orgnization orgnization = orgnizationRepository.findOne(orgnizationId);
		referenceStation.setOrgnization(orgnization);
		return referenceStationRepository.save(referenceStation);
	}

	@Override
	public void delete(int id) {
		referenceStationRepository.delete(id);
	}

	@Override
	public void update(ReferenceStation referenceStation) {
		referenceStationRepository.save(referenceStation);

	}

	@Override
	public List<ReferenceStation> findAll() {
		return referenceStationRepository.findAll();
	}

	@Override
	public ReferenceStation findById(int id) {
		return referenceStationRepository.findOne(id);
	}

	@Override
	public List<ReferenceStation> findByName(String name) {
		return referenceStationRepository.findByName(name);
	}

	

}
