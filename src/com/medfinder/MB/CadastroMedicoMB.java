package com.medfinder.MB;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
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
public class CadastroMedicoMB implements Serializable{

	
	private static final long serialVersionUID = 1L;

	private Medico medico;

	private List<Plano> todosPlanos;

	private List<Plano> escolhidosPlanos;

	private DualListModel<Plano> dualPlanos;

	private List<Especialidade> todasEspecialidades;

	private List<Especialidade> especialidades;

	private DualListModel<Especialidade> dualEspecialidades;
	
	private Especialidade especialidade;
	
	private Consultorio consultorio;
	
	private Endereco endereco;
	
	private TelefoneConsultorio telefone;

	MedicoDAO medao = new MedicoDAO();
	PlanoDAO pldao = new PlanoDAO();
	EspecialidadeDAO espdao = new EspecialidadeDAO();
	
	
	
	

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

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}

	public DualListModel<Especialidade> getDualEspecialidades() {
		return dualEspecialidades;
	}

	public void setDualEspecialidades(
			DualListModel<Especialidade> dualEspecialidades) {
		this.dualEspecialidades = dualEspecialidades;
	}

	public DualListModel<Plano> getDualPlanos() {
		return dualPlanos;
	}

	public void setDualPlanos(DualListModel<Plano> dualPlanos) {
		this.dualPlanos = dualPlanos;
	}

	public List<Plano> getEscolhidosPlanos() {
		return escolhidosPlanos;
	}

	public void setEscolhidosPlanos(List<Plano> escolhidosPlanos) {
		this.escolhidosPlanos = escolhidosPlanos;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public List<Plano> getTodosPlanos() {
		return todosPlanos;
	}

	public void setTodosPlanos(List<Plano> todosPlanos) {
		this.todosPlanos = todosPlanos;
	}

	public List<Especialidade> getTodasEspecialidades() {
		return todasEspecialidades;
	}

	public void setTodasEspecialidades(List<Especialidade> todasEspecialidades) {
		this.todasEspecialidades = todasEspecialidades;
	}

	@PostConstruct
	public void init() {

		medico = new Medico();
		consultorio = new Consultorio();
		endereco = new Endereco();
		telefone = new TelefoneConsultorio();
		
		todosPlanos = pldao.listAll();
		escolhidosPlanos = new ArrayList<Plano>();		
		dualPlanos = new DualListModel<Plano>(todosPlanos, escolhidosPlanos);

		todasEspecialidades = espdao.listAll();
		especialidades = new ArrayList<Especialidade>();
		dualEspecialidades = new DualListModel<Especialidade>(todasEspecialidades, especialidades);
	}
	
	public void processFileUpload(FileUploadEvent event) {
		
		System.out.println("Cheguei no file");
		 
        try {
            medico.setFoto(event.getFile().getContents()); 
            System.out.println(event.getFile().getFileName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
 
    }

	public void salvarMedico() {

		escolhidosPlanos = this.dualPlanos.getTarget();

		medico.setPlanos(escolhidosPlanos);

		for (Plano p : escolhidosPlanos) {
			System.out.println(p.getDs_plano());
		}

		especialidades = this.dualEspecialidades.getTarget();

		medico.setEspecialidades(especialidades);
		consultorio.setEndereco(endereco);
		consultorio.setTelefone(telefone);
		medico.setConsultorio(consultorio);

		for (Especialidade e : especialidades) {
			System.out.println("Especialidade do médico: "+e.getDs_especialidade());
		}
		System.out.println(medico.getFoto().toString());
		
		System.out.println("Salvou o médico :)");
		

		medao.insert(medico);

	}
}
