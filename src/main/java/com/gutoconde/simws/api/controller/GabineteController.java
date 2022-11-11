package com.gutoconde.simws.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gutoconde.simws.model.RepositorioGabinete;
import com.gutoconde.simws.model.RepositorioServidor;
import com.gutoconde.simws.model.entity.Gabinete;
import com.gutoconde.simws.model.entity.Servidor;

@RestController
@RequestMapping("/rest/gabinete")
public class GabineteController {
	
	@Autowired
	private RepositorioGabinete repositorioGabinete;
	
	@Autowired
	private RepositorioServidor repositorioServidor;

	public GabineteController() {	
	}
	
	@GetMapping
	public Iterable<Gabinete> listAll() {
		Iterable<Gabinete> gabinetes = repositorioGabinete.findAll();
		return gabinetes;
	}

	@GetMapping(path = "/{codigo}/servidores", produces = "application/json")
	public Iterable<Servidor> listarServidores(@PathVariable String codigo) {
		return repositorioServidor.findByIdGabinete(codigo);
	}
}
