package com.cors.web.service;


import java.util.List;

import com.cors.web.entity.Orgnization;

public interface IOrgnizationService {
	public Orgnization add(Orgnization orgnization);
	public void delete(int id);
	public void update(Orgnization orgnization);
	public List<Orgnization> findAll();
	public Orgnization findById(int id);
	public List<Orgnization> findByName(String name);

}
