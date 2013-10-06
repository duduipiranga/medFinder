package com.medfinder.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "AM_CONSULTORIO")
@SequenceGenerator(name="seqConsultorio", sequenceName="SEQ_CONSULTORIO", allocationSize=1)
public class Consultorio implements Serializable {

	private static final long serialVersionUID = 1768343578722643153L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqConsultorio")
	private int id_consultorio;

	@JoinColumn(name = "ID_ENDERECO")
	@OneToOne(targetEntity = Endereco.class, cascade = CascadeType.ALL)
	private Endereco endereco;

	private String nome;

	@JoinColumn(name = "ID_TELEFONE")
	@OneToOne(targetEntity = TelefoneConsultorio.class, cascade = CascadeType.ALL)
	private TelefoneConsultorio telefone;

	@Lob
	private byte[] foto;
	
	
	@OneToMany(mappedBy = "consultorio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Medico> medicos;
	
	
	
	
	
	

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public TelefoneConsultorio getTelefone() {
		return telefone;
	}

	public void setTelefone(TelefoneConsultorio telefone) {
		this.telefone = telefone;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}
	
	public int getId_consultorio() {
		return id_consultorio;
	}

	public void setId_consultorio(int id_consultorio) {
		this.id_consultorio = id_consultorio;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
