package com.gutoconde.simws.model.entity;

import java.util.List;
import java.util.Objects;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="cargo")
public class Cargo {
	
	@DynamoDBHashKey
	private String codigo;
	
	@DynamoDBAttribute
	private List<HistoricoVencimentoCargo> historicosVencimentoCargo;
	
	public Cargo() {
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<HistoricoVencimentoCargo> getHistoricosVencimentoCargo() {
		return historicosVencimentoCargo;
	}

	public void setHistoricosVencimentoCargo(List<HistoricoVencimentoCargo> historicosVencimentoCargo) {
		this.historicosVencimentoCargo = historicosVencimentoCargo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cargo other = (Cargo) obj;
		return Objects.equals(codigo, other.codigo);
	}

	@Override
	public String toString() {
		return "Cargo {codigo: " + codigo + "}";
	}
	
	
}
