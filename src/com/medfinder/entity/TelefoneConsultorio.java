package com.medfinder.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="AM_TELEFONE_CONSULTORIO")
public class TelefoneConsultorio implements Serializable {

	
	
	private static final long serialVersionUID = 1388629405596255304L;

	@Id
	private int id_telefone;
	
	private BigInteger numero;		
	

	

	public int getId_telefone() {
		return id_telefone;
	}

	public void setId_telefone(int id_telefone) {
		this.id_telefone = id_telefone;
	}

	public BigInteger getNumero() {
		return numero;
	}

	public void setNumero(BigInteger numero) {
		this.numero = numero;
	}
	
	
	
	
	
}
