package com.gutoconde.simws.model;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.gutoconde.simws.integracao.ServicoImportacaoGabinete;
import com.gutoconde.simws.integracao.ServicoImportacaoServidor;

@Service
public class TarefaImportacaoDados {

	private ServicoImportacaoServidor servicoImportacaoServidor;
	
	private ServicoImportacaoGabinete servicoImportacaoGabinete;
	
	public TarefaImportacaoDados(ServicoImportacaoServidor servicoImportacaoServidor,
			ServicoImportacaoGabinete servicoImportacaoGabinete) {
		this.servicoImportacaoServidor = servicoImportacaoServidor;
		this.servicoImportacaoGabinete = servicoImportacaoGabinete;
		
	}
	
	@Scheduled(cron="${simws.agendamento.importacao}")
	//@EventListener(ApplicationReadyEvent.class)
	public void executarImportacao() {
		servicoImportacaoGabinete.importarGabinetes();
		servicoImportacaoServidor.importarServidores();
	}
	
}
