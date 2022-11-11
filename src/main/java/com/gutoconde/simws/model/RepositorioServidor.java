package com.gutoconde.simws.model;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gutoconde.simws.model.entity.Servidor;

@Repository
@EnableScan
public interface RepositorioServidor extends CrudRepository<Servidor, String>{
	
	List<Servidor> findByIdGabinete(String idGabinete);
}
