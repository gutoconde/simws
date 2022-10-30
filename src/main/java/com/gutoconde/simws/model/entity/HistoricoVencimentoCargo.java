package com.gutoconde.simws.model.entity;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "historicovencimentocargo")
public class HistoricoVencimentoCargo {

	@Id
	@GeneratedValue()
	private Integer id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idcargo")
	@JsonIgnore
	private Cargo cargo;
	
	@Column(name="vencimento")
	private Float vencimento;
	
	@Column(name="grg")
	private Float grg;
	
	@Column(name = "datainicio")
	@JsonFormat(pattern="yyyy-MM-dd")
	private String dataInicio;
	
	@Column(name="datafim", nullable = true)
	@JsonFormat(pattern="yyyy-MM-dd")
	private String dataFim;
	
	@Column(name="datacancelamento", nullable = true )
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private String dataCancelamento;
	
	public HistoricoVencimentoCargo() {
		
	}
	
	public Integer getId() {
		return id;
	}
	
	

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
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
		return this.dataInicio;
	}

	public void setDataInicio(String dataInicioValue) {
		this.dataInicio = dataInicioValue;
	}
	
	public String getDataFim() {
		return this.dataFim;
	}

	public void setDataFim(String dataFimValue) {
		this.dataInicio = dataFimValue;
	}
	
	
	public String getDataCancelamento() {
		return dataCancelamento;
	}

	public void setDataCancelamento(String dataCancelamento) {
		this.dataCancelamento = dataCancelamento;
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
		HistoricoVencimentoCargo other = (HistoricoVencimentoCargo) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
