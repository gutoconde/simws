package com.gutoconde.simws.integracao.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class RespostaDTO<T> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<T> dados;
	
	public RespostaDTO() {
		
	}
	
	public List<T> getDados() {
		return dados;
	}

	public void setDados(List<T> dados) {
		this.dados = dados;
	}

}
