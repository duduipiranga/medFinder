package com.medfinder.MB;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

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
public class BuscaMedicoBean implements Serializable {

	private static final long serialVersionUID = 2814850488945255572L;

	private List<Medico> medicos;

	private List<Plano> planos;

	private List<Especialidade> especialidades;	

	private List<SelectItem> planosList;	

	private Plano plano;
	
	private MapModel locMedicos;

	private Especialidade especialidade;
	
	
	
	public MapModel getLocMedicos() {
		return locMedicos;
	}

	public void setLocMedicos(MapModel locMedicos) {
		this.locMedicos = locMedicos;
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

	

	public List<SelectItem> getPlanosList() {
		return planosList;
	}

	public void setPlanosList(List<SelectItem> planosList) {
		this.planosList = planosList;
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
		
		especialidades = espdao.listAll();
		
		planosList = new ArrayList<SelectItem>();
		planos = pdao.listAll();
		
		for (Plano p : planos) {
			planosList.add(new SelectItem(p.getId_plano(), p.getDs_plano()));
		}		
		plano = new Plano();
		especialidade = new Especialidade();
		
		
	}

	

	public void buscarMedicos() {
		
		double lat = 0;
		double lon = 0;
		
		if (plano == null) {
			medicos = mdao.retornaMedicosSoPorEspecialidade(especialidade);
		} else {
			medicos = mdao.retornaMedicosPorEspecialidadePorPlano(especialidade, plano);
		}
		
		for (Medico m : medicos) {
			lat = Double.parseDouble(m.getConsultorio().getEndereco().getLatitude());
			lon = Double.parseDouble(m.getConsultorio().getEndereco().getLongitude());
			locMedicos.addOverlay(new Marker(new LatLng(lat, lon)));
		}

	}

}