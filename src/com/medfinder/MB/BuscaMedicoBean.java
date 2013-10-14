package com.medfinder.MB;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import com.medfinder.dao.impl.EspecialidadeDAO;
import com.medfinder.dao.impl.MedicoDAO;
import com.medfinder.dao.impl.OperadoraDAO;
import com.medfinder.dao.impl.PlanoDAO;
import com.medfinder.entity.Especialidade;
import com.medfinder.entity.Medico;
import com.medfinder.entity.Plano;

@ManagedBean
@ViewScoped
public class BuscaMedicoBean implements Serializable {

	

	
	private static final long serialVersionUID = 1366274330306826385L;

	private List<Medico> medicos;

	private List<Plano> planos;

	private List<Especialidade> especialidades;	

	private List<SelectItem> planosList;	

	private Plano plano;
	
	private MapModel locMedicos;

	private Especialidade especialidade;
	
	private double latitude;
	
	private double longitude;
	
	
	
	

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

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
		
		latitude = 0;
		longitude = 0;
		
		
	}
	
	public void valores(){
		System.out.println(latitude);
		System.out.println(longitude);
	}
	
	 
 
	public void buscarMedicos() {
		System.out.println("Chegou na busca!");
		double lat = 0;
		double lon = 0;
		
		
		locMedicos = new DefaultMapModel();
		
		medicos = new ArrayList<Medico>();
		
		if(plano.getId_plano() == 0) {
			medicos = mdao.retornaMedicosSoPorEspecialidade(especialidade);
		} else {
			medicos = mdao.retornaMedicosPorEspecialidadePorPlano(especialidade, plano);
		} 	
		
		System.out.println(latitude);
		System.out.println(longitude);
		
		locMedicos.addOverlay(new Marker(new LatLng(latitude, longitude),"Você","","http://maps.google.com/mapfiles/ms/micons/red-dot.png"));
		
		//Medico med = mdao.find("29506084120");
		//medicos.add(med);
		
		for (Medico med : medicos) {
			lat = Double.parseDouble(med.getConsultorio().getEndereco().getLatitude());
			lon = Double.parseDouble(med.getConsultorio().getEndereco().getLongitude());
			System.out.println(lat);
			System.out.println(lon);
			
			locMedicos.addOverlay(new Marker(new LatLng(lat, lon),med.getNome(),"","http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));
		}
	}
	public void onMarkerSelect(OverlaySelectEvent event) {  

	    Marker marker = (Marker) event.getOverlay();
	    if (marker!=null) {
	        System.out.println(marker.getId());
	    }
	}
	
	public void chamarPerfil(){
		
		
	}

}