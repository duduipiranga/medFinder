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
	
	private List<SelectItem> planos;
	
	private List<Plano> planosList;

	private Date dataNasc;
	private String senha;
	private String cep;
	
	
	public List<Plano> getPlanosList() {
		return planosList;
	}

	public void setPlanosList(List<Plano> planosList) {
		this.planosList = planosList;
	}

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

	public List<SelectItem> getPlanos() {
		return planos;
	}

	public void setPlanos(List<SelectItem> planos) {
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
		planosList = pdao.listAll();
		planos = new ArrayList<SelectItem>();
		
		for (Plano p : planosList) {
			planos.add(new SelectItem(p));
		}		
		
		plano = new Plano();		
		
	}
	
	
}
