package com.gutoconde.simws.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/appinfo")
public class AppInfoController {
	
	@Value("${app.version:-}") 
	private String versao;

	@GetMapping(path = "/versao", produces = "application/json")
	public String versao() {
		return versao;
	}
	
}
