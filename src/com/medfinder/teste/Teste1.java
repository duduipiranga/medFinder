package com.medfinder.teste;

import java.util.List;

import com.medfinder.dao.impl.ConsultorioDAOImpl;
import com.medfinder.entity.Consultorio;
import com.medfinder.entity.Telefone_Consultorio;

public class Teste1 {
	
	public static void main(String[] args) {
		
		ConsultorioDAOImpl cdao = new ConsultorioDAOImpl();
		
		List<Consultorio> c = cdao.listAll();
		
		List<Telefone_Consultorio> telefones = null;
		
		for (Consultorio consultorio : c) {
			
			telefones = consultorio.getTelefones();
			
			for (Telefone_Consultorio telefone_Consultorio : telefones) {
				System.out.println(telefone_Consultorio.getNumero());
			}
			
		}
		
		/*OperadoraDAOImpl opdao = new OperadoraDAOImpl();
		
		
		List<Operadora> op = opdao.listAll();
		
		for (Operadora operadora : op) {
			System.out.println(operadora.getDs_operadora());
		}*/
		
	}

}
