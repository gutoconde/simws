package com.gutoconde.simws.integracao.dto;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.gutoconde.simws.model.entity.Gabinete;

public class GabineteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String uri;
    private String nome;
    private Integer idLegislaturaFinal;
    private String nomeCivil;
    private String siglaSexo;
    
    private static final String PATTERN_URI_GABINETES = "https://dadosabertos.camara.leg.br/api/v2/deputados/(\\d+)";
    
	public GabineteDTO() {
		
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdLegislaturaFinal() {
		return idLegislaturaFinal;
	}

	public void setIdLegislaturaFinal(Integer idLegislaturaFinal) {
		this.idLegislaturaFinal = idLegislaturaFinal;
	}

	public String getNomeCivil() {
		return nomeCivil;
	}

	public void setNomeCivil(String nomeCivil) {
		this.nomeCivil = nomeCivil;
	}

	public String getSiglaSexo() {
		return siglaSexo;
	}

	public void setSiglaSexo(String siglaSexo) {
		this.siglaSexo = siglaSexo;
	}
	
	public String getCodigoLotacao() {
		String codigoLotacao = null;
		if(getUri() != null && !getUri().isEmpty()) {
			Pattern pattern = Pattern.compile(PATTERN_URI_GABINETES);
			Matcher matcher = pattern.matcher(getUri());
			codigoLotacao = matcher.find() ? matcher.group(1) : null;
		}
		return codigoLotacao;
	}
	
	public Gabinete toEntity() {
		Gabinete gabinete = new Gabinete();
		gabinete.setNome(nome);
		gabinete.setCodigo(getCodigoLotacao());
		return gabinete;
	}

	@Override
	public String toString() {
		return "GabineteDTO {uri: " + uri + ", nome: " + nome + ", idLegislaturaFinal: " + idLegislaturaFinal
				+ ", nomeCivil: " + nomeCivil + ", siglaSexo: " + siglaSexo + "}";
	}

}
