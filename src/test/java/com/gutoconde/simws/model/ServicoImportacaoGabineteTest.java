package com.gutoconde.simws.model;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gutoconde.simws.integracao.ServicoImportacaoGabinete;
import com.gutoconde.simws.integracao.dto.GabineteDTO;

@SpringBootTest
public class ServicoImportacaoGabineteTest {

	@Autowired
	ServicoImportacaoGabinete servico;
	
	@Test
	public void testarListarGabinetes() {
		List<GabineteDTO> gabinetes = servico.listarGabinetes();
		for (GabineteDTO gabinete : gabinetes) {
			System.out.println(gabinete);
		}
	}
	
	@Test
	public void testarImportarGabinetes() {
		servico.importarGabinetes();
	}
}
