package com.medfinder.MB;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import com.medfinder.dao.impl.EspecialidadeDAO;
import com.medfinder.dao.impl.MedicoDAO;
import com.medfinder.dao.impl.OperadoraDAO;
import com.medfinder.dao.impl.PlanoDAO;
import com.medfinder.entity.Especialidade;
import com.medfinder.entity.Medico;
import com.medfinder.entity.Operadora;
import com.medfinder.entity.Plano;

@ManagedBean
@ViewScoped
public class BuscaMedicoMB implements Serializable{	
	
	private static final long serialVersionUID = 2814850488945255572L;


	private List<Medico> medicos;	
	
	private List<Plano> planos;
	
	private List<Especialidade> especialidades;

	private List<Operadora> operadoras;

	private List<SelectItem> planosList;

	private List<SelectItem> operadorasList;
	
	private Plano plano;
	
	private Operadora operadora;
	
	private Especialidade especialidade;
	
	
	
	
	

	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

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
	MedicoDAO mdao = new MedicoDAO();
	EspecialidadeDAO espdao = new EspecialidadeDAO();

	
	
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

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
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
		especialidades = espdao.listAll();

	}
	
	public void listaPlanosAjax() {
		System.out.println("Chegou nos planos");
		planos = pdao.getPlanosByOperadora(operadora);
		
		
		for (Plano p : planos) {
			System.out.println(p.getDs_plano());
		}
		}
	
	public void buscarMedicos(){
		if(plano == null){
			mdao.retornaMedicosSoPorEspecialidade(especialidade);
		}else{
			mdao.retornaMedicosPorEspecialidadePorPlano(especialidade, plano);
		}  
		
	}
	

}
