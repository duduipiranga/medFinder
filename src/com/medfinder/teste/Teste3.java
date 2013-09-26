package com.medfinder.teste;

import java.util.ArrayList;
import java.util.List;

import com.medfinder.dao.impl.MedicoDAO;
import com.medfinder.entity.Especialidade;
import com.medfinder.entity.Medico;
import com.medfinder.entity.Plano;

public class Teste3 {
	public static void main(String[] args) {
		
		MedicoDAO mdao = new MedicoDAO();
		List<Medico> medicos = new ArrayList<Medico>();
		
		Plano p = new Plano();
		p.setId_plano(13);
		
		Especialidade e = new Especialidade();
		e.setId_especialidade(2);
		
		
		medicos = mdao.retornaMedicosPorEspecialidadePorPlano(e, p);
		System.out.println("Teste comecando");
		for (Medico medico : medicos) {
			System.out.println(medico.getNome());
		}
		
	}

}
