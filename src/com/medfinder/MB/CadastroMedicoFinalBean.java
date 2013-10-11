package com.medfinder.MB;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

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
public class CadastroMedicoFinalBean implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{cadastroMedicoBean.medico}")
	private Medico medico;	
	
	private Consultorio consultorio;
	
	private Endereco endereco;
	
	private TelefoneConsultorio telefone;

	MedicoDAO medao = new MedicoDAO();
	
	
	
	
	

	public TelefoneConsultorio getTelefone() {
		return telefone;
	}

	public void setTelefone(TelefoneConsultorio telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Consultorio getConsultorio() {
		return consultorio;
	}

	public void setConsultorio(Consultorio consultorio) {
		this.consultorio = consultorio;
	}

	

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	

	@PostConstruct
	public void init() {

		
	}
	
	
	
public void fileUploadConsultorio(FileUploadEvent event) {
		
		System.out.println("Cheguei no file");
		 
        try {
            consultorio.setFoto(event.getFile().getContents()); 
            System.out.println(event.getFile().getFileName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
 
    }

	public void salvarMedico() {
		
		//escolhidosPlanos = this.dualPlanos.getTarget();

		
		consultorio.setEndereco(endereco);
		consultorio.setTelefone(telefone);
		medico.setConsultorio(consultorio);

		
		System.out.println(medico.getFoto().toString());
		
		System.out.println("Salvou o médico :)");
		

		medao.insert(medico);

	}
}
