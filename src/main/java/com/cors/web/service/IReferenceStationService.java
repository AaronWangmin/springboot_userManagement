package com.cors.web.service;


import java.util.List;

import com.cors.web.entity.ReferenceStation;

public interface IReferenceStationService {
	public ReferenceStation add(ReferenceStation referenceStation);
	public ReferenceStation add(ReferenceStation referenceStation, int orgnizationId);
	public void delete(int id);
	public void update(ReferenceStation referenceStation);
	public List<ReferenceStation> findAll();
	public ReferenceStation findById(int id);
	public List<ReferenceStation> findByName(String name);

}
