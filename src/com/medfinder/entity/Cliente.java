package com.medfinder.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name="AM_CLIENTE")
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3319870289667091764L;

	@Id
	private String id_cliente;
	
	@JoinColumn(name = "ID_PLANO")
	@OneToOne(targetEntity = Plano.class)
	private Plano plano;
	
	private String nome;
	
	private String sobrenome;
	
	private String email;
	
	private String senha;
	
	private Calendar dt_nascimento;
	
	@JoinColumn(name = "ID_ENDERECO")
	@OneToOne(targetEntity = Endereco.class)
	private Endereco endereco;
	
	@Transient
	private Telefone_Cliente[] telefones;
	
	
	
	

	
	public Telefone_Cliente[] getTelefones() {
		return telefones;
	}

	public void setTelefones(Telefone_Cliente[] telefones) {
		this.telefones = telefones;
	}

	public String getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(String id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
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

	public Calendar getDt_nascimento() {
		return dt_nascimento;
	}

	public void setDt_nascimento(Calendar dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	
}
