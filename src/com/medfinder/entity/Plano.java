package com.medfinder.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="AM_PLANO")
@SequenceGenerator(name="seqPlano",
sequenceName="SEQ_PLANO",allocationSize=1)
public class Plano implements Serializable{	
	private static final long serialVersionUID = 6373208908026122920L;

	@Id
	private int id_plano;
	
	private String ds_plano;
	
	@JoinColumn(name="ID_OPERADORA")
	@ManyToOne(targetEntity=Operadora.class)
	private Operadora operadora;
	
	
	
	
	
	

	public int getId_plano() {
		return id_plano;
	}

	public void setId_plano(int id_plano) {
		this.id_plano = id_plano;
	}

	public String getDs_plano() {
		return ds_plano;
	}

	public void setDs_plano(String ds_plano) {
		this.ds_plano = ds_plano;
	}

	public Operadora getOperadora() {
		return operadora;
	}

	public void setOperadora(Operadora operadora) {
		this.operadora = operadora;
	}
	
	
	

}
