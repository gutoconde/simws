package com.gutoconde.simws.model.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cargo")
public class Cargo {
	
	@Id
	@GeneratedValue()
	private Integer id;
	
	@Column(name = "codigo")
	private String codigo;
	
	@OneToMany(mappedBy = "cargo")
	private List<HistoricoVencimentoCargo> historicoVencimentoCargo;
	
	public Cargo() {
	}
	
	public Integer getId() {
		return id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<HistoricoVencimentoCargo> getHistoricoVencimentoCargo() {
		return historicoVencimentoCargo;
	}

	public void setHistoricoVencimentoCargo(List<HistoricoVencimentoCargo> historicoVencimentoCargo) {
		this.historicoVencimentoCargo = historicoVencimentoCargo;
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
}
