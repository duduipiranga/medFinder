package com.medfinder.MB;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.medfinder.bo.EspecialidadeBOProxy;
import com.medfinder.to.Especialidade;


@ManagedBean
@ViewScoped
public class AdminEspecialidades implements Serializable{
	
	
	private static final long serialVersionUID = 6016657003583554578L;

	private Especialidade especialidade;
	
	private Especialidade novaEspecialidade;
	
	private int id_especialidade;
	
	private int novoId_especialidade;
	
	private Especialidade[] arrayEspecialidades;
	
	private List<Especialidade> especialidades;
	
	private String message;
	
	
	
	

	public Especialidade getNovaEspecialidade() {
		return novaEspecialidade;
	}



	public void setNovaEspecialidade(Especialidade novaEspecialidade) {
		this.novaEspecialidade = novaEspecialidade;
	}



	public int getNovoId_especialidade() {
		return novoId_especialidade;
	}



	public void setNovoId_especialidade(int novoId_especialidade) {
		this.novoId_especialidade = novoId_especialidade;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public Especialidade getEspecialidade() {
		return especialidade;
	}



	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}



	public Especialidade[] getArrayEspecialidades() {
		return arrayEspecialidades;
	}



	public void setArrayEspecialidades(Especialidade[] arrayEspecialidades) {
		this.arrayEspecialidades = arrayEspecialidades;
	}



	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}



	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}



	public int getId_especialidade() {
		return id_especialidade;
	}



	public void setId_especialidade(int id_especialidade) {
		this.id_especialidade = id_especialidade;
	}



	


	EspecialidadeBOProxy bo = new EspecialidadeBOProxy();

	
	@PostConstruct
	public void init(){
		especialidade = new Especialidade();
		novaEspecialidade = new Especialidade();
		
	}
	
	public void pesquisarEspecialidade(){
		System.out.println("Cheguei no pesquisar");
		try {
			especialidade = bo.consultarEspecialidade(id_especialidade);
			System.out.println(especialidade.getNm_especialidade());
		} catch (RemoteException e) {			
			e.printStackTrace();
		}
	}
	
	public void trazerTodasEspecialidades(){
		System.out.println("Cheguei na lista");
		try {
			arrayEspecialidades = bo.listarEspecialidades();
			
			especialidades = new ArrayList<Especialidade>();
			
			for (Especialidade esp : arrayEspecialidades) {
				especialidades.add(esp);
			}
			System.out.println(especialidade.getNm_especialidade());
		} catch (RemoteException e) {			
			e.printStackTrace();
		}
	}
	
	public void inserirEspecialidade(){
		try {
			bo.inserirEspecialidade(novaEspecialidade);
		} catch (RemoteException e) {			
			e.printStackTrace();
		}
		 
	        FacesContext context = FacesContext.getCurrentInstance();  
	          
	        context.addMessage(null, new FacesMessage("Confirmado", "A especialidade " + novaEspecialidade.getNm_especialidade() + " foi adicionada."));  
	         
	     novaEspecialidade = new Especialidade();
	}
	

	

}
