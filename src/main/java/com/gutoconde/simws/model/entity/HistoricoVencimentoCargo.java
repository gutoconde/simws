package com.gutoconde.simws.model.entity;

import java.io.Serializable;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.fasterxml.jackson.annotation.JsonFormat;

@DynamoDBDocument
public class HistoricoVencimentoCargo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@DynamoDBAttribute
	private Float vencimento;
	
	@DynamoDBAttribute
	private Float grg;
	
	@DynamoDBAttribute(attributeName = "dataInicio")
	@JsonFormat(pattern="yyyy-MM-dd")
	private String dataInicio;
	
	@DynamoDBAttribute(attributeName = "dataFim")
	@JsonFormat(pattern="yyyy-MM-dd")
	private String dataFim;
	
	@DynamoDBAttribute(attributeName = "dataCancelamento")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private String dataCancelamento;
	
	public HistoricoVencimentoCargo() {
		
	}	
	
	public Float getVencimento() {
		return vencimento;
	}

	public void setVencimento(Float vencimento) {
		this.vencimento = vencimento;
	}

	public Float getGrg() {
		return grg;
	}

	public void setGrg(Float grg) {
		this.grg = grg;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	public String getDataCancelamento() {
		return dataCancelamento;
	}

	public void setDataCancelamento(String dataCancelamento) {
		this.dataCancelamento = dataCancelamento;
	}
}
