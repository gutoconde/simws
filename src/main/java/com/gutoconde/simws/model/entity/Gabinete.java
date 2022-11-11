package com.gutoconde.simws.model.entity;

import java.util.Objects;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="gabinete")
public class Gabinete {

	@DynamoDBHashKey
	private String id;
	
	@DynamoDBAttribute
	private String nome;
	
	
	public Gabinete() {
	}
	
	public Gabinete(String id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
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
		Gabinete other = (Gabinete) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Gabinete {id: " + id + ", nome: " + nome + "}";
	}
}
