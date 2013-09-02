package com.medfinder.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="AM_MEDICO")
public class Medico implements Serializable {

	/**
	 * 
	 */
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
	
	@Transient
	private HorarioAtendimento[] horarios;
	
	
	
	
	public HorarioAtendimento[] getHorarios() {
		return horarios;
	}
	public void setHorarios(HorarioAtendimento[] horarios) {
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
