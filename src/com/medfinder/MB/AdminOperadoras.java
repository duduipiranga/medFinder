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

import com.medfinder.bo.OperadoraBOProxy;
import com.medfinder.to.Operadora;


@ManagedBean
@ViewScoped
public class AdminOperadoras implements Serializable {
	private static final long serialVersionUID = -6200505465991319828L;

	private Operadora operadora;
	
	private Operadora novaOperadora;

	private int id_operadora;

	private Operadora[] arrayOperadoras;

	private List<Operadora> operadoras;

	private String message;
	
	
	

	public Operadora getNovaOperadora() {
		return novaOperadora;
	}

	public void setNovaOperadora(Operadora novaOperadora) {
		this.novaOperadora = novaOperadora;
	}

	public Operadora getOperadora() {
		return operadora;
	}

	public void setOperadora(Operadora operadora) {
		this.operadora = operadora;
	}

	public int getId_operadora() {
		return id_operadora;
	}

	public void setId_operadora(int id_operadora) {
		this.id_operadora = id_operadora;
	}

	public Operadora[] getArrayOperadoras() {
		return arrayOperadoras;
	}

	public void setArrayOperadoras(Operadora[] arrayOperadoras) {
		this.arrayOperadoras = arrayOperadoras;
	}

	public List<Operadora> getOperadoras() {
		return operadoras;
	}

	public void setOperadoras(List<Operadora> operadoras) {
		this.operadoras = operadoras;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
OperadoraBOProxy bo = new OperadoraBOProxy();

	
	@PostConstruct
	public void init(){
		operadora = new Operadora();
		novaOperadora = new Operadora();
		
	}
	
	public void pesquisarOperadora(){
		System.out.println("Cheguei no pesquisar");
		try {
			operadora = bo.consultarOperadora(id_operadora);
			System.out.println(operadora.getDs_operadora());
		} catch (RemoteException e) {			
			e.printStackTrace();
		}
	}
	
	public void trazerTodasOperadoras(){
		System.out.println("Cheguei na lista");
		try {
			arrayOperadoras = bo.listarOperadoras();
			
			operadoras = new ArrayList<Operadora>();
			
			for (Operadora esp : arrayOperadoras) {
				operadoras.add(esp);
			}
			System.out.println(operadora.getDs_operadora());
		} catch (RemoteException e) {			
			e.printStackTrace();
		}
	}
	
	public void inserirOperadora(){
		try {
			bo.inserirOperadora(novaOperadora);
		} catch (RemoteException e) {			
			e.printStackTrace();
		}
		 
	        FacesContext context = FacesContext.getCurrentInstance();  
	          
	        context.addMessage(null, new FacesMessage("Confirmado", "A Operadora " + novaOperadora.getDs_operadora() + " foi adicionada."));  
	         
	        novaOperadora = new Operadora();
	}
	
	

}
