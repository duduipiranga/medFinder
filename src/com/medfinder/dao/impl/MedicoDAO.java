package com.medfinder.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import com.medfinder.entity.Especialidade;
import com.medfinder.entity.Medico;
import com.medfinder.entity.Plano;

public class MedicoDAO extends HibernateDAO<Medico, String> {

	List<Medico> medicos = new ArrayList<Medico>();

	public List<Medico> retornaMedicosSoPorEspecialidade(
			Especialidade especialidade) {
		Query q = em
				.createQuery("From Medico m where m.especialidades = :id_especialidade");
		q.setParameter("id_especialidade", especialidade.getId_especialidade());

		medicos = q.getResultList();

		return medicos;
	}

	public List<Medico> retornaMedicosPorEspecialidadePorPlano(
			Especialidade especialidade, Plano plano) {
		Query q = em
				.createQuery("From Medico m where m.especialidades = :id_especialidade and m.planos = :id_plano");
		q.setParameter("id_especialidade", especialidade.getId_especialidade());
		q.setParameter("id_plano", plano.getId_plano());
		
		medicos = q.getResultList();
		
		
		return medicos;
	}

}
