package com.gutoconde.simws.model.entity;

import java.util.Objects;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;


@DynamoDBTable(tableName = "servidor")
public class Servidor {
	
	@DynamoDBHashKey
	private String id;
	
	@DynamoDBAttribute
	private String nome;
	
	@DynamoDBAttribute
	private String idGabinete;
	
	@DynamoDBAttribute
	private String codigoCargo;
	
	public Servidor() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdGabinete() {
		return idGabinete;
	}

	public void setIdGabinete(String idGabinete) {
		this.idGabinete = idGabinete;
	}

	public String getCodigoCargo() {
		return codigoCargo;
	}

	public void setCodigoCargo(String codigoCargo) {
		this.codigoCargo = codigoCargo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servidor other = (Servidor) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		return "Servidor {id: " + id + ", nome: " + nome + ", idGabinete: " + idGabinete
				+ ", codigoCargo: " + codigoCargo + "}";
	}
}
