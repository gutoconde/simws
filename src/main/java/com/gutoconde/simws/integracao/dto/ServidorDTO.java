package com.gutoconde.simws.integracao.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.gutoconde.simws.model.entity.Servidor;

public class ServidorDTO implements Serializable {

	private static final String PATTERN_URI_GABINETES = "https://dadosabertos.camara.leg.br/api/v2/deputados/(\\d+)";

	private static final long serialVersionUID = 1L;

	private String ponto;

	private String codGrupo;

	private String grupo;

	private String nome;

	private String cargo;

	private String lotacao;

	private String atoNomeacao;

	private LocalDate dataNomeacao;

	private LocalDate dataInicioHistorico;

	private LocalDate dataPubNomeacao;

	private String funcao;

	private String uriLotacao;

	public ServidorDTO() {
	}

	public String getPonto() {
		return ponto;
	}

	public void setPonto(String ponto) {
		this.ponto = ponto;
	}

	public String getCodGrupo() {
		return codGrupo;
	}

	public void setCodGrupo(String codGrupo) {
		this.codGrupo = codGrupo;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getCargoSP() {
		return this.cargo != null && this.cargo.length() >= 4 ? cargo.substring(0, 4) : null;
	}

	public String getLotacao() {
		return lotacao;
	}

	public void setLotacao(String lotacao) {
		this.lotacao = lotacao;
	}

	public String getAtoNomeacao() {
		return atoNomeacao;
	}

	public void setAtoNomeacao(String atoNomeacao) {
		this.atoNomeacao = atoNomeacao;
	}

	public LocalDate getDataNomeacao() {
		return dataNomeacao;
	}

	public void setDataNomeacao(LocalDate dataNomeacao) {
		this.dataNomeacao = dataNomeacao;
	}

	public LocalDate getDataInicioHistorico() {
		return dataInicioHistorico;
	}

	public void setDataInicioHistorico(LocalDate dataInicioHistorico) {
		this.dataInicioHistorico = dataInicioHistorico;
	}

	public LocalDate getDataPubNomeacao() {
		return dataPubNomeacao;
	}

	public void setDataPubNomeacao(LocalDate dataPubNomeacao) {
		this.dataPubNomeacao = dataPubNomeacao;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getUriLotacao() {
		return uriLotacao;
	}

	public void setUriLotacao(String uriLotacao) {
		this.uriLotacao = uriLotacao;
	}

	public String getCodigoLotacao() {
		String codigoLotacao = null;
		if (getUriLotacao() != null && !getUriLotacao().isEmpty()) {
			Pattern pattern = Pattern.compile(PATTERN_URI_GABINETES);
			Matcher matcher = pattern.matcher(getUriLotacao());
			codigoLotacao = matcher.find() ? matcher.group(1) : null;
		}
		return codigoLotacao;
	}

	public Servidor toEntity() {
		Servidor servidor = new Servidor();
		servidor.setNome(nome);
		servidor.setPonto(ponto);
		return servidor;
	}

	@Override
	public String toString() {
		return "ServidorDTO {ponto: " + ponto + ", codGrupo: " + codGrupo + ", grupo: " + grupo + ", nome: " + nome
				+ ", cargo: " + cargo + ", lotacao: " + lotacao + ", atoNomeacao: " + atoNomeacao + ", dataNomeacao: "
				+ dataNomeacao + ", dataInicioHistorico: " + dataInicioHistorico + ", dataPubNomeacao: "
				+ dataPubNomeacao + ", funcao: " + funcao + ", uriLotacao: " + uriLotacao + "}";
	}

}
