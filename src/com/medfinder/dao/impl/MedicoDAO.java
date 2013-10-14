package com.medfinder.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import com.medfinder.entity.Especialidade;
import com.medfinder.entity.Medico;
import com.medfinder.entity.Plano;

public class MedicoDAO extends HibernateDAO<Medico, String> implements Serializable{

	
	private static final long serialVersionUID = -9162816324974680263L;
	List<Medico> medicos = new ArrayList<Medico>();

	public List<Medico> retornaMedicosSoPorEspecialidade(
			Especialidade especialidade) {
		Query q = em
				.createQuery("select m from Medico m inner join m.especialidades e where e.id_especialidade = :id_especialidade");
		q.setParameter("id_especialidade", especialidade.getId_especialidade());

		medicos = q.getResultList();

		return medicos;
	}

	public List<Medico> retornaMedicosPorEspecialidadePorPlano(
			Especialidade especialidade, Plano plano) {
		Query q = em
				.createQuery("select m from Medico m inner join m.especialidades e inner join m.planos p where e.id_especialidade = :id_especialidade and p.id_plano = :id_plano ");
		q.setParameter("id_especialidade", especialidade.getId_especialidade());
		q.setParameter("id_plano", plano.getId_plano());

		medicos = q.getResultList();

		return medicos;
	}
	public List<Medico> sortearEspecialidades(){
		Query q = em
				.createQuery("from Medico");
		
		medicos = q.getResultList();

		return medicos;
	}
	

}
