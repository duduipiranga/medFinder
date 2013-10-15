package com.medfinder.dao.impl;

import javax.persistence.Query;

import com.medfinder.entity.Cliente;



public class ClienteDAO extends HibernateDAO<Cliente,String>{
	
	Cliente cliente = new Cliente();
	
	public boolean validarUsuario(String email, String senha){	
		
		Query q = em.createQuery("from Cliente c where c.email = :email and c.senha = :senha" ,Cliente.class);
		q.setParameter("email", email);
		q.setParameter("senha", senha);
		
		try{
			cliente = (Cliente) q.getSingleResult();
			return true;
		}catch(javax.persistence.NoResultException e){
			return false;		
		}		
	}

}
