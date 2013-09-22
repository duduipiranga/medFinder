package com.medfinder.MB;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;

import com.medfinder.dao.impl.OperadoraDAO;
import com.medfinder.dao.impl.PlanoDAO;
import com.medfinder.entity.Operadora;
import com.medfinder.entity.Plano;

@ManagedBean
@ViewScoped
public class HomeBean {

	private List<Plano> planos;

	private List<Operadora> operadoras;

	private List<SelectItem> planosList;

	private List<SelectItem> operadorasList;
	
	private Plano plano;
	
	private Operadora operadora;
	
	

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public Operadora getOperadora() {
		return operadora;
	}

	public void setOperadora(Operadora operadora) {
		this.operadora = operadora;
	}

	PlanoDAO pdao = new PlanoDAO();
	OperadoraDAO opdao = new OperadoraDAO();

	
	
	public List<Plano> getPlanos() {
		return planos;
	}

	public void setPlanos(List<Plano> planos) {
		this.planos = planos;
	}

	public List<Operadora> getOperadoras() {
		return operadoras;
	}

	public void setOperadoras(List<Operadora> operadoras) {
		this.operadoras = operadoras;
	}

	public List<SelectItem> getPlanosList() {
		return planosList;
	}

	public void setPlanosList(List<SelectItem> planosList) {
		this.planosList = planosList;
	}

	public List<SelectItem> getOperadorasList() {
		return operadorasList;
	}

	public void setOperadorasList(List<SelectItem> operadorasList) {
		this.operadorasList = operadorasList;
	}

	public String cadastrar() {
		String retorno = "cadastroCliente?faces-redirect=true";

		return retorno;
	}

	public String loginCliente() {
		String retorno = "loginCliente?faces-redirect=true";

		return retorno;

	}

	@PostConstruct
	public void init() {
		operadorasList = new ArrayList<SelectItem>();
		operadoras = opdao.listAll();

	}
	
	public void listaPlanosAjax() {
		System.out.println("Chegou nos planos");
		planos = pdao.getPlanosByOperadora(operadora);
		
		
		for (Plano p : planos) {
			System.out.println(p.getDs_plano());
		}
		}

}
