package com.cors.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cors.web.entity.Orgnization;

public interface OrgnizationRepository extends JpaRepository<Orgnization, Integer> {
	
	public List<Orgnization> findByName(String name);

}
