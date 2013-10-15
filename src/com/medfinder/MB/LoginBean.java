package com.medfinder.MB;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.medfinder.dao.impl.ClienteDAO;
import com.medfinder.dao.impl.MedicoDAO;
import com.medfinder.entity.Cliente;
import com.medfinder.entity.Medico;


@ManagedBean
@SessionScoped
public class LoginBean implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	
	
	private Medico medico;
	
	private Cliente cliente;
	
	private List<Medico> medicos;
	
	private List<Cliente> clientes;
	
	private boolean loginCorreto;
	
	private String url;
	
	
	
	
	
	

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public boolean isLoginCorreto() {
		return loginCorreto;
	}

	public void setLoginCorreto(boolean loginCorreto) {
		this.loginCorreto = loginCorreto;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	MedicoDAO mdao = new MedicoDAO();
	ClienteDAO cdao= new ClienteDAO();
	
	@PostConstruct
	public void init(){
		medico = new Medico();
		cliente = new Cliente();
		medicos = new ArrayList<Medico>();
		clientes = new ArrayList<Cliente>();
		
	}
	
	public String logarMedico(){		
		loginCorreto = mdao.validarUsuario(medico.getEmail(), medico.getSenha());			
		if(loginCorreto == true){
			url = "perfilMedico";
		}else{
			FacesContext context = FacesContext.getCurrentInstance(); 	          
	        context.addMessage(null, new FacesMessage("Erro", "Seu usuário e/ou senha estão incorretos"));
	        url = "index";
		}		
		return url;
	}
	
	public String logarCliente(){
		loginCorreto = cdao.validarUsuario(cliente.getEmail(), cliente.getSenha());			
			if(loginCorreto == true){
				url = "buscaMedicos";
			}else{
				FacesContext context = FacesContext.getCurrentInstance();		          
		        context.addMessage(null, new FacesMessage("Erro", "Seu usuário e/ou senha estão incorretos"));		        
		        url ="index";
			}			
		return url;
	}
	
	
	
	
	
	

}
