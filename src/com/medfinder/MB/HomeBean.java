package com.medfinder.MB;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.medfinder.dao.impl.OperadoraDAO;
import com.medfinder.dao.impl.PlanoDAO;
import com.medfinder.entity.Operadora;
import com.medfinder.entity.Plano;

@ManagedBean
@RequestScoped
public class HomeBean {
	
	private List<Plano> planos;
	
	private List<Operadora> operadoras;
	
	
	
	
	PlanoDAO pdao = new PlanoDAO();
	OperadoraDAO opdao = new OperadoraDAO(); 
	

	public String cadastrar() {
		String retorno = "cadastroCliente?faces-redirect=true";

		return retorno;
	}

	public String loginCliente() {
		String retorno = "loginCliente?faces-redirect=true";

		return retorno;

	}
	
	public void init(){
		
		operadoras = opdao.listAll();
		
		
		
	}

}
