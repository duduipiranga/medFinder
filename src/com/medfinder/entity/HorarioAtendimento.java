package com.medfinder.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="AM_HORARIO_ATENDIMENTO")
public class HorarioAtendimento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8233429872252645135L;

	@Id
	private int id_horario;	
	
	@ManyToOne
	@JoinColumn(name = "ID_MEDICO")
	private Medico medico;
	
	@ManyToOne
	@JoinColumn(name = "ID_CONSULTORIO")
	private Consultorio consultorio;
	
	private String horario;
	
	private String dia_semana;
	
	
	
	
	

	public int getId_horario() {
		return id_horario;
	}

	public void setId_horario(int id_horario) {
		this.id_horario = id_horario;
	}

	public Consultorio getConsultorio() {
		return consultorio;
	}

	public void setConsultorio(Consultorio consultorio) {
		this.consultorio = consultorio;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getDia_semana() {
		return dia_semana;
	}

	public void setDia_semana(String dia_semana) {
		this.dia_semana = dia_semana;
	}
	
	
	
	
}
