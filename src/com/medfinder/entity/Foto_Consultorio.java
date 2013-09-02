package com.medfinder.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="AM_FOTO_CONSULTORIO")
public class Foto_Consultorio implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5363359688499094451L;

	@Id
	private int id_foto;
	
	@Lob
	private byte[] foto;
	
	private String ds_foto;
	
	
	

	public int getId_foto() {
		return id_foto;
	}

	public void setId_foto(int id_foto) {
		this.id_foto = id_foto;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getDs_foto() {
		return ds_foto;
	}

	public void setDs_foto(String ds_foto) {
		this.ds_foto = ds_foto;
	}
	
	
	
	
	
}
