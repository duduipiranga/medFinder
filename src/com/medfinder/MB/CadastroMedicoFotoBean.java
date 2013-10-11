package com.medfinder.MB;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DualListModel;
import com.medfinder.dao.impl.EspecialidadeDAO;
import com.medfinder.dao.impl.MedicoDAO;
import com.medfinder.dao.impl.PlanoDAO;
import com.medfinder.entity.Consultorio;
import com.medfinder.entity.Endereco;
import com.medfinder.entity.Especialidade;
import com.medfinder.entity.Medico;
import com.medfinder.entity.Plano;
import com.medfinder.entity.TelefoneConsultorio;

@ManagedBean
@SessionScoped
public class CadastroMedicoFotoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Medico medico;

	
	MedicoDAO medao = new MedicoDAO();
	
	
	
	
	

	
	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	

	@PostConstruct
	public void init() {

		medico = new Medico();
		
	}
	
	public void fileUploadMedico(FileUploadEvent event) {
		
		System.out.println("Cheguei no file");
		 
        try {
            medico.setFoto(event.getFile().getContents()); 
            System.out.println(event.getFile().getFileName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
	


	public String irParaCadastro() {		
		
		System.out.println(medico.getFoto().toString());		

		return "cadastroMedico";

	}
}
