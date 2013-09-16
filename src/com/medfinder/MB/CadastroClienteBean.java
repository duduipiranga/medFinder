package com.medfinder.MB;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import com.medfinder.dao.impl.PlanoDAO;
import com.medfinder.entity.Cliente;
import com.medfinder.entity.Plano;

@SessionScoped
@ManagedBean
public class CadastroClienteBean {
	
	
	private Cliente cliente;
	
	private Plano plano;
	
	private List<Plano> planos;

	private Date dataNasc;
	private String senha;
	private String cep;
	
	

	
	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public List<Plano> getPlanos() {
		return planos;
	}

	public void setPlanos(List<Plano> planos) {
		this.planos = planos;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	PlanoDAO pdao = new PlanoDAO();
	
	
	
	@PostConstruct
	public void init(){
		cliente = new Cliente();
		planos = pdao.listAll();
		plano = new Plano();		
		
	}
	
	
}
