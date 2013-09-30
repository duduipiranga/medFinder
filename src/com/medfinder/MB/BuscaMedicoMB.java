package com.medfinder.MB;



import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
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
	private static final long serialVersionUID = -2703908329964124708L;
	
	
	

	private List<Medico> medicos;	
	
	private List<Plano> planos;
	
	private List<Especialidade> especialidades;

	private List<Operadora> operadoras;

	private List<SelectItem> planosList;

	private List<SelectItem> operadorasList;
	
	private Plano plano;
	
	private Operadora operadora;
	
	private Especialidade especialidade;
	
	private String enderecoPrefixo;
	
	private String enderecoSufixo;

	

	public String getEnderecoPrefixo() {
		return enderecoPrefixo;
	}

	public void setEnderecoPrefixo(String enderecoPrefixo) {
		this.enderecoPrefixo = enderecoPrefixo;
	}

	public String getEnderecoSufixo() {
		return enderecoSufixo;
	}

	public void setEnderecoSufixo(String enderecoSufixo) {
		this.enderecoSufixo = enderecoSufixo;
	}

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
		operadoras = opdao.listAll();
		
		for (Operadora op : operadoras) {
			System.out.println(op.getId_operadora());
		}
		
		especialidades = espdao.listAll();

	}
	
	public void listaPlanosAjax(AjaxBehaviorEvent event) {
		System.out.println("Chegou nos planos");
		planos = pdao.getPlanosByOperadora(operadora);
		
		
		for (Plano p : planos) {
			System.out.println(p.getDs_plano());
		}
		}
	
	public void buscarMedicos(){
		System.out.println("Chegou aqui");
		if(plano == null){
			medicos = mdao.retornaMedicosSoPorEspecialidade(especialidade);
		}else{
			medicos = mdao.retornaMedicosPorEspecialidadePorPlano(especialidade, plano);
		}  
		
		enderecoSufixo = " Sao Paulo, Brazil";
		
	}
	
	public void qqCoisa(ActionEvent ae){
		System.out.println("Qualquer coisa");
		
	}
	

}
