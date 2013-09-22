package com.medfinder.teste;

import java.util.List;

import com.medfinder.dao.impl.OperadoraDAO;
import com.medfinder.dao.impl.PlanoDAO;
import com.medfinder.entity.Operadora;
import com.medfinder.entity.Plano;

public class Teste2 {
	public static void main(String[] args) {
		PlanoDAO pdao = new PlanoDAO();
		OperadoraDAO opdao = new OperadoraDAO(); 
		
		List<Operadora> operadoras = opdao.listAll();
		
		Operadora op = operadoras.get(7);
		
		
		
		List<Plano> planos = pdao.getPlanosByOperadora(op);
		
		for (Plano plano : planos) {
			System.out.println(plano.getId_plano());
		}
	}
}
