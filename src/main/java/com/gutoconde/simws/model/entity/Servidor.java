package com.gutoconde.simws.model.entity;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="servidor")
public class Servidor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "ponto")
	private String ponto;
	
	@Column(name = "nome")
	private String nome;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="idgabinete")
	private Gabinete lotacao;
	
	@Column(name = "codigocargo")
	private String codigoCargo;
	
	public Servidor() {
	}
	
	public Long getId() {
		return id;
	}

	public String getPonto() {
		return ponto;
	}

	public void setPonto(String ponto) {
		this.ponto = ponto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Gabinete getLotacao() {
		return lotacao;
	}

	public void setLotacao(Gabinete lotacao) {
		this.lotacao = lotacao;
	}

	public String getCodigoCargo() {
		return codigoCargo;
	}

	public void setCodigoCargo(String codigoCargo) {
		this.codigoCargo = codigoCargo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ponto);
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
		return Objects.equals(ponto, other.ponto);
	}
	
	@Override
	public String toString() {
		return "Servidor {id: " + id + ", ponto: " + ponto + ", nome: " + nome + ", lotacao: " + lotacao
				+ ", codigoCargo: " + codigoCargo + "}";
	}
}
