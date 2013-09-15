package com.medfinder.teste;

import java.util.List;

import com.medfinder.dao.impl.ConsultorioDAO;
import com.medfinder.entity.Consultorio;
import com.medfinder.entity.TelefoneConsultorio;

public class Teste1 {
	
	public static void main(String[] args) {
		
		ConsultorioDAO cdao = new ConsultorioDAO();
		
		List<Consultorio> c = cdao.listAll();
		
		List<TelefoneConsultorio> telefones = null;
		
		for (Consultorio consultorio : c) {
			
			telefones = consultorio.getTelefones();
			
			for (TelefoneConsultorio telefoneConsultorio : telefones) {
				System.out.println(telefoneConsultorio.getNumero());
			}
			
		}
		
		/*OperadoraDAO opdao = new OperadoraDAO();
		
		
		List<Operadora> op = opdao.listAll();
		
		for (Operadora operadora : op) {
			System.out.println(operadora.getDs_operadora());
		}*/
		
	}

}
