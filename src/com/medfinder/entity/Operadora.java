package com.medfinder.entity;

import java.io.Serializable;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="AM_OPERADORA")
@SequenceGenerator(name="seqOperadora",
sequenceName="SEQ_OPERADORA",allocationSize=1)
public class Operadora implements Serializable{	
	private static final long serialVersionUID = 3844228944594846039L;

	@Id
	@GeneratedValue(generator="seqOperadora",
	strategy=GenerationType.SEQUENCE)
	
	private int id_operadora;	
	
	private String ds_operadora;	
	
	@OneToMany(mappedBy = "operadora", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Plano> planos;
	
	
	
	public List<Plano> getPlanos() {
		return planos;
	}
	public void setPlanos(List<Plano> planos) {
		this.planos = planos;
	}
	public int getId_operadora() {
		return id_operadora;
	}
	public void setId_operadora(int id_operadora) {
		this.id_operadora = id_operadora;
	}
	public String getDs_operadora() {
		return ds_operadora;
	}
	public void setDs_operadora(String ds_operadora) {
		this.ds_operadora = ds_operadora;
	}
	
	
	
	

}
