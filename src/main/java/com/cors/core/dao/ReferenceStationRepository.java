package com.cors.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cors.core.entity.ReferenceStation;

public interface ReferenceStationRepository extends JpaRepository<ReferenceStation, Integer> {
	
	public List<ReferenceStation> findByName(String name);

}
