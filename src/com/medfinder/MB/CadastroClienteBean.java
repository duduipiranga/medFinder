package com.medfinder.MB;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import com.medfinder.dao.impl.ClienteDAO;
import com.medfinder.dao.impl.PlanoDAO;
import com.medfinder.entity.Cliente;
import com.medfinder.entity.Endereco;
import com.medfinder.entity.Plano;

@ViewScoped
@ManagedBean
public class CadastroClienteBean implements Serializable{	

	
	private static final long serialVersionUID = 1L;
	
	private String id;

	private Cliente cliente;
	
	private Plano plano;	
	
	private List<Plano> planos;

	private Endereco endereco;
	
	private List<SelectItem> listaPlanos;
	
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<SelectItem> getListaPlanos() {
		return listaPlanos;
	}

	public void setListaPlanos(List<SelectItem> listaPlanos) {
		this.listaPlanos = listaPlanos;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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

	public List<Plano> getPlanos() {
		return planos;
	}

	public void setPlanos(List<Plano> planos) {
		this.planos = planos;
	}

	
	
	PlanoDAO pdao = new PlanoDAO();
	ClienteDAO cdao = new ClienteDAO();
	
	
	@PostConstruct
	public void init(){
		cliente = new Cliente();
		endereco = new Endereco();
		
		listaPlanos = new ArrayList<SelectItem>();
		planos = pdao.listAll();
		
		for (Plano p : planos) {
			listaPlanos.add(new SelectItem(p.getId_plano(), p.getDs_plano()));
		}
		
		plano = new Plano();			
		
	}
	
	public void salvarCliente(){
		
		System.out.println("Chegou no salvar, porra!");
		cliente.setPlano(plano);
		cliente.setEndereco(endereco);
		
		cdao.insert(cliente);		
	}
	
	
}
