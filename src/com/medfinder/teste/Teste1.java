package com.medfinder.teste;

import java.util.ArrayList;
import java.util.List;

import com.medfinder.dao.impl.HorarioAtendimentoDAO;
import com.medfinder.dao.impl.MedicoDAO;
import com.medfinder.entity.HorarioAtendimento;
import com.medfinder.entity.Medico;

public class Teste1 {
	
	public static void main(String[] args) {
		
		/*ConsultorioDAO cdao = new ConsultorioDAO();
		
		List<Consultorio> c = cdao.listAll();
		
		List<TelefoneConsultorio> telefones = null;
		
		for (Consultorio consultorio : c) {
			
			telefones = consultorio.getTelefones();
			
			for (TelefoneConsultorio telefoneConsultorio : telefones) {
				System.out.println(telefoneConsultorio.getNumero());
			}
			
		}*/
		
		/*OperadoraDAO opdao = new OperadoraDAO();
		
		
		List<Operadora> op = opdao.listAll();
		
		for (Operadora operadora : op) {
			System.out.println(operadora.getDs_operadora());
		}*/
		
		
		MedicoDAO mdao= new MedicoDAO();
		
		
		
		List<Medico> meds = mdao.listAll();
		
		List<HorarioAtendimento> horarios = new ArrayList<HorarioAtendimento>();
		
		
		for (int i = 0; i < meds.size(); i++) {
			System.out.println(meds.get(i).getSobrenome());
			horarios = meds.get(i).getHorarios();
			
			
			for (HorarioAtendimento horarioAtendimento : horarios) {
				System.out.println("dia: "+horarioAtendimento.getDia_semana()+" Horario: "+horarioAtendimento.getHorario());
				System.out.println("Proximo");
			}
		}
		
		
		
	}

}
