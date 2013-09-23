package com.medfinder.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "AM_MEDICO")
public class Medico implements Serializable {

	
	private static final long serialVersionUID = 2686422646871037810L;

	@Id
	private String id_medico;
	private String nome;
	private String sobrenome;
	private String crm;
	private String email;
	private String senha;
	private BigDecimal vl_consulta;

	@Lob
	private byte[] foto;
	private String resumo_profissional;
	private String ds_formacao;

	@OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<HorarioAtendimento> horarios;

	@ManyToMany	
	@JoinTable(name = "AM_PLANO_MEDICO",
	joinColumns = @JoinColumn(name = "id_medico") ,
	inverseJoinColumns = @JoinColumn(name = "id_plano"))
	private List<Plano> planos;
	
	
	@ManyToMany(fetch = FetchType.LAZY)	
	@JoinTable(name = "AM_MEDICO_ESPECIALIDADE",
	joinColumns = @JoinColumn(name = "id_medico"),
	inverseJoinColumns = @JoinColumn(name = "id_especialidade"))
	private List<Especialidade> especialidades;
	
	
	@JoinColumn(name="ID_CONSULTORIO")	
	@ManyToOne(targetEntity=Consultorio.class,cascade=CascadeType.ALL)
	private Consultorio consultorio;
	
	
	

	public Consultorio getConsultorio() {
		return consultorio;
	}

	public void setConsultorio(Consultorio consultorio) {
		this.consultorio = consultorio;
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

	public List<HorarioAtendimento> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<HorarioAtendimento> horarios) {
		this.horarios = horarios;
	}

	public String getId_medico() {
		return id_medico;
	}

	public void setId_medico(String id_medico) {
		this.id_medico = id_medico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public BigDecimal getVl_consulta() {
		return vl_consulta;
	}

	public void setVl_consulta(BigDecimal vl_consulta) {
		this.vl_consulta = vl_consulta;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getResumo_profissional() {
		return resumo_profissional;
	}

	public void setResumo_profissional(String resumo_profissional) {
		this.resumo_profissional = resumo_profissional;
	}

	public String getDs_formacao() {
		return ds_formacao;
	}

	public void setDs_formacao(String ds_formacao) {
		this.ds_formacao = ds_formacao;
	}

}
