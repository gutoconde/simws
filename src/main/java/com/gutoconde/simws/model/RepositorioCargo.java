package com.gutoconde.simws.model;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gutoconde.simws.model.entity.Cargo;

@Repository
@EnableScan
public interface RepositorioCargo extends CrudRepository<Cargo, Integer>{

	Cargo findByCodigo(String codigo);
}
