package com.medfinder.MB;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.medfinder.dao.impl.MedicoDAO;
import com.medfinder.entity.Consultorio;
import com.medfinder.entity.Endereco;
import com.medfinder.entity.Especialidade;
import com.medfinder.entity.Medico;
import com.medfinder.entity.Plano;

@ManagedBean
@SessionScoped
public class PerfilMedicoBean {

	@ManagedProperty(value = "#{chamaPerfilMedico.id_medico}")
	private String id_medico;

	private Medico medico;

	private List<Especialidade> especialidades;

	private List<Plano> planos;

	private Consultorio consultorio;

	private Endereco endereco;

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}

	public List<Plano> getPlanos() {
		return planos;
	}

	public void setPlanos(List<Plano> planos) {
		this.planos = planos;
	}

	public Consultorio getConsultorio() {
		return consultorio;
	}

	public void setConsultorio(Consultorio consultorio) {
		this.consultorio = consultorio;
	}

	public String getId_medico() {
		return id_medico;
	}

	public void setId_medico(String id_medico) {
		this.id_medico = id_medico;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	@PostConstruct
	public void init() {
		MedicoDAO mdao = new MedicoDAO();
		System.out.println("id do medico é: " + id_medico);
		medico = mdao.find(id_medico);
		planos = medico.getPlanos();
		especialidades = medico.getEspecialidades();
		consultorio = medico.getConsultorio();
		endereco = consultorio.getEndereco();

	}

}
