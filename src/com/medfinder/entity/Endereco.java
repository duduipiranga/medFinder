package com.medfinder.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="AM_ENDERECO")
@SequenceGenerator(name="seqEndereco", sequenceName="SEQ_ENDERECO", allocationSize=1)
public class Endereco implements Serializable{		
	private static final long serialVersionUID = -7163407954172996476L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqEndereco")
	private int id_endereco;
	
	private String logradouro;
	
	private int numero;
	
	private String complemento;
	
	private String bairro;
	
	private int cep;
	
	private String latitude;
	
	private String longitude;
	
	
	
	
	

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public int getId_endereco() {
		return id_endereco;
	}

	public void setId_endereco(int id_endereco) {
		this.id_endereco = id_endereco;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
