package com.gutoconde.simws.integracao;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gutoconde.simws.integracao.dto.RespostaDTO;
import com.gutoconde.simws.integracao.dto.ServidorDTO;
import com.gutoconde.simws.model.RepositorioGabinete;
import com.gutoconde.simws.model.RepositorioServidor;
import com.gutoconde.simws.model.entity.Gabinete;
import com.gutoconde.simws.model.entity.Servidor;

@Service
public class ServicoImportacaoServidor {
	
	private static Logger logger = LoggerFactory.getLogger(ServicoImportacaoGabinete.class);
	
	@Value("${simws.dadosabertos.servidores.url}")
	private String urlServidores;

	@Autowired
	private RepositorioServidor repositorioServidor;
	
	@Autowired
	private RepositorioGabinete repositorioGabinete;
	
	public ServicoImportacaoServidor() {
	}
	
	public void importarServidores() {
		logger.debug("Limpando a base de servidores.");
		repositorioServidor.deleteAll();
		logger.debug("Base de servidores limpa.");
		
		List<ServidorDTO> servidores = listarServidores();
		int servidoresLidos = 0;
		int servidoresImportados = 0;
		
		for (ServidorDTO ser : servidores) {
			if(ser.getCodGrupo().equals("6")) {
				Servidor servidor = ser.toEntity();
				servidoresLidos++;
				try {
					Optional<Gabinete> opGabinete = repositorioGabinete.findById(ser.getCodigoLotacao());
					if(opGabinete.isPresent()) {
						servidor.setIdGabinete(opGabinete.get().getId());
						servidor.setCodigoCargo(ser.getCargo());
						repositorioServidor.save(servidor);
					}
					
					servidoresImportados++;
				}catch(Exception e) {
					logger.error("Erro ao importar servidor.", e);
					logger.error("Dados do servidor com erro na importação : " + ser);
				}
			}
		}
		
		logger.debug("Importacao de servidores finalizada." + servidoresLidos + " servidores consultados e " + servidoresImportados + " servidores importados.");
	}
	
	public List<ServidorDTO> listarServidores() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<RespostaDTO<ServidorDTO>> resposta = restTemplate.exchange(urlServidores, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<RespostaDTO<ServidorDTO>>() {});
		RespostaDTO<ServidorDTO> resp = resposta.getBody();
		return resp.getDados() ;
	}
}
