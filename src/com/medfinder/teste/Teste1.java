package com.medfinder.teste;

import java.util.ArrayList;
import java.util.List;

import com.medfinder.dao.impl.MedicoDAO;
import com.medfinder.entity.HorarioAtendimento;
import com.medfinder.entity.Medico;
import com.medfinder.entity.Plano;

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
		
		List<Plano> planos = new ArrayList<Plano>();
		
		for (Medico m : meds) {
			planos = m.getPlanos();
			
			for (Plano plano : planos) {
				System.out.println(plano.getId_plano());
			}
		}
		
		
		
		
		/*for (int i = 0; i < meds.size(); i++) {			
			horarios = meds.get(i).getHorarios();
			
			
			for (HorarioAtendimento horarioAtendimento : horarios) {
				System.out.println("dia: "+horarioAtendimento.getDia_semana()+" Horario: "+horarioAtendimento.getHorario());
				System.out.println("Proximo");
			}
		}
		*/
		
		
	}

}
