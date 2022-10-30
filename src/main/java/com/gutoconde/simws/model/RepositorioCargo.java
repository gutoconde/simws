package com.gutoconde.simws.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gutoconde.simws.model.entity.Cargo;

@Repository
public interface RepositorioCargo extends CrudRepository<Cargo, Integer>{

	Cargo findByCodigo(String codigo);
}
