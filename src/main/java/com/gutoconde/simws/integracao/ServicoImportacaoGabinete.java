package com.gutoconde.simws.integracao;

import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.gutoconde.simws.integracao.dto.GabineteDTO;
import com.gutoconde.simws.integracao.dto.RespostaDTO;
import com.gutoconde.simws.model.RepositorioGabinete;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ServicoImportacaoGabinete {
	
	private static Logger logger = LoggerFactory.getLogger(ServicoImportacaoGabinete.class);
	
	private RepositorioGabinete repositorioGabinete;
	
	@Value("${simws.dadosabertos.gabinetes.url}")
	private String urlGabinetes;
	
	public ServicoImportacaoGabinete(RepositorioGabinete repositorioGabinete) {
		this.repositorioGabinete = repositorioGabinete;
	}
	
	public void importarGabinetes() {
		logger.debug("Iniciando importacao de gabinetes");
		logger.debug("Limpando a base de gabinetes");
		repositorioGabinete.deleteAll();
		logger.debug("Base de gabinetes limpa");
		
		List<GabineteDTO> gabinetes = listarGabinetes();
		logger.debug(gabinetes.size() + " gabinetes consultados para importacao");
		
		int gabinetesImportados = 0;
		
		for (GabineteDTO gabinete : gabinetes) {
			try {
				repositorioGabinete.save(gabinete.toEntity());
				gabinetesImportados++;
			} catch(Exception e) {
				logger.error("Erro na importacao de gabinete", e);
				logger.error("Dados do gabinete com erro na importação : " + gabinete);
			}
		}
		logger.debug("Importacao de gabinetes finalizada. " + gabinetesImportados + " gabinetes importados.");
	}
	
	public List<GabineteDTO> listarGabinetes() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<RespostaDTO<GabineteDTO>> resposta = restTemplate.exchange(urlGabinetes, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<RespostaDTO<GabineteDTO>>() {});
		RespostaDTO<GabineteDTO> resp = resposta.getBody();
		return resp.getDados() ;
	}
	
	

}
