package com.medfinder.MB;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class ChamaPerfilMedico implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	
	
	private String id_medico;
	
	

	public String getId_medico() {
		return id_medico;
	}

	public void setId_medico(String id_medico) {
		this.id_medico = id_medico;
	}
	
	
	
	
	public String chamaPerfilMedico(){		
		//return "NewFile3";
		return "perfilMedico";
	}
	
	
	
	
	
}
