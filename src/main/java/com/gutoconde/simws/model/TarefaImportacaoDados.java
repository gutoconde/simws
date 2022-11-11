package com.gutoconde.simws.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.gutoconde.simws.integracao.ServicoImportacaoGabinete;
import com.gutoconde.simws.integracao.ServicoImportacaoServidor;

@Service
public class TarefaImportacaoDados {

	@Autowired
	private ServicoImportacaoServidor servicoImportacaoServidor;
	
	@Autowired
	private ServicoImportacaoGabinete servicoImportacaoGabinete;
	
	public TarefaImportacaoDados() {
	}
	
	@Scheduled(cron="${simws.agendamento.importacao}")
	//@EventListener(ApplicationReadyEvent.class)
	public void executarImportacao() {
		servicoImportacaoGabinete.importarGabinetes();
		servicoImportacaoServidor.importarServidores();
	}
	
}
