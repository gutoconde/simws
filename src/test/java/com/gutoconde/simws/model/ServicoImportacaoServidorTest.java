package com.gutoconde.simws.model;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gutoconde.simws.integracao.ServicoImportacaoGabinete;
import com.gutoconde.simws.integracao.ServicoImportacaoServidor;
import com.gutoconde.simws.integracao.dto.ServidorDTO;

@SpringBootTest
public class ServicoImportacaoServidorTest {

	@Autowired
	private ServicoImportacaoServidor servico;
	
	@Autowired
	private ServicoImportacaoGabinete servicoImportacaoGabinte;
	
	@Test
	public void testarListarServidores() {
		List<ServidorDTO> servidores = servico.listarServidores();
		for (ServidorDTO servidor : servidores) {
			System.out.println(servidor);
		}
	}
	
	@Test
	public void testarImportarServidores() {
		servicoImportacaoGabinte.importarGabinetes();
		servico.importarServidores();
	}
}
