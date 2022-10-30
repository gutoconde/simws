package com.gutoconde.simws.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gutoconde.simws.model.entity.Gabinete;

@Repository
public interface RepositorioGabinete extends CrudRepository<Gabinete, Integer> {
	
	//@Cacheable
	//List<Gabinete> findAll();
	
	Gabinete findByCodigo(String codigo);
	
}
