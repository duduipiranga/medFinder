package com.medfinder.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="AM_RECOMENDACAO_CLIENTE")
public class RecomendacaoCliente implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4264634679489169266L;

	@Id
	private int id_recomendacao;
	
	@ManyToOne
	@JoinColumn(name = "ID_CLIENTE")
	private Cliente cliente;
	
	
	@ManyToOne
	@JoinColumn(name = "ID_MEDICO")
	private Medico medico;
	
	
	

	public int getId_recomendacao() {
		return id_recomendacao;
	}

	public void setId_recomendacao(int id_recomendacao) {
		this.id_recomendacao = id_recomendacao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	
	
	
	
}
