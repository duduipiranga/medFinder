package com.medfinder.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AM_ESPECIALIDADE")
public class Especialidade implements Serializable {

	
	private static final long serialVersionUID = 7122420261975133740L;

	@Id
	private int id_especialidade;
	
	private String nm_especialidade;
	
	private String ds_especialidade;
	
	/*@ManyToMany(mappedBy="especialidades")
	private List<Medico> medico;
	
	
	
	
	public List<Medico> getMedico() {
		return medico;
	}

	public void setMedico(List<Medico> medico) {
		this.medico = medico;
	}*/

	public int getId_especialidade() {
		return id_especialidade;
	}

	public void setId_especialidade(int id_especialidade) {
		this.id_especialidade = id_especialidade;
	}

	public String getNm_especialidade() {
		return nm_especialidade;
	}

	public void setNm_especialidade(String nm_especialidade) {
		this.nm_especialidade = nm_especialidade;
	}

	public String getDs_especialidade() {
		return ds_especialidade;
	}

	public void setDs_especialidade(String ds_especialidade) {
		this.ds_especialidade = ds_especialidade;
	}

	
	
	
}
