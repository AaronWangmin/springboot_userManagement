package com.cors.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cors.core.entity.Orgnization;

public interface OrgnizationRepository extends JpaRepository<Orgnization, Integer> {
	
	public List<Orgnization> findByName(String name);

}
