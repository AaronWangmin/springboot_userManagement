package com.cors.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cors.web.entity.ReferenceStation;

public interface ReferenceStationRepository extends JpaRepository<ReferenceStation, Integer> {
	
	public List<ReferenceStation> findByName(String name);

}
