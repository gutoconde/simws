package com.gutoconde.simws.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gutoconde.simws.model.RepositorioCargo;
import com.gutoconde.simws.model.entity.Cargo;

@RestController
@RequestMapping("/rest/cargo")
public class CargoController {
	
	@Autowired
	private RepositorioCargo repositorioCargo;
	
	public CargoController() {
	}
	
	@GetMapping
    public Iterable<Cargo> listAll(){
		Iterable<Cargo> cargos = repositorioCargo.findAll();
        return cargos;
	}
}
