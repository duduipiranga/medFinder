package com.medfinder.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import com.medfinder.entity.Operadora;
import com.medfinder.entity.Plano;

public class PlanoDAO extends HibernateDAO<Plano,Integer> implements Serializable{	
	private static final long serialVersionUID = 3846415168863029032L;

	public List<Plano> getPlanosByOperadora(Operadora op){
		
		List<Plano> planos; 
		Query q = em.createQuery("from Plano p where p.operadora = :operadora",Plano.class);
		q.setParameter("operadora", op);
		
		planos = q.getResultList();
		
		return planos;
	}

}
