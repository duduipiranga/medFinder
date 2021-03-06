package com.medfinder.MB;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
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
public class CadastroMedicoBean implements Serializable {

	/**
	 * 
	 */
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
	
	private String latitude;
	
	private String longitude;

	MedicoDAO medao = new MedicoDAO();
	PlanoDAO pldao = new PlanoDAO();
	EspecialidadeDAO espdao = new EspecialidadeDAO();
	
	

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

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
		dualEspecialidades = new DualListModel<Especialidade>(
				todasEspecialidades, especialidades);
	}

	public void abrirDialogMedico() {
		System.out.println("cheguei no abrir dialog");
		RequestContext.getCurrentInstance().openDialog("cadastroMedicoFoto");
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

	public void abrirDialogConsultorio() {
		System.out.println("cheguei no abrir dialog");
		RequestContext.getCurrentInstance().openDialog(
				"cadastroMedicoFotoConsultorio");
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

		medico.setPlanos(escolhidosPlanos);

		for (Plano p : escolhidosPlanos) {
			System.out.println(p.getDs_plano());
		}

		medico.setEspecialidades(especialidades);

		for (Especialidade e : especialidades) {
			System.out.println("Especialidade do m�dico: "
					+ e.getDs_especialidade());
		}

		consultorio.setEndereco(endereco);
		consultorio.setTelefone(telefone);
		medico.setConsultorio(consultorio);

		System.out.println(medico.getFoto().toString());

		System.out.println("Salvou o m�dico :)");

		medao.insert(medico);
		
		FacesContext context = FacesContext.getCurrentInstance(); 
		context.addMessage(null, new FacesMessage("Sucesso", "M�dico cadastrado com sucesso! ")); 
		
		//return "index?faces-redirect=true";

	}
}
