package com.medfinder.teste;

import java.rmi.RemoteException;

import com.medfinder.bo.EspecialidadeBOProxy;
import com.medfinder.to.Especialidade;


public class Teste1 {
	public static void main(String[] args) {
		
		int id = 9;
		
		EspecialidadeBOProxy ebo = new EspecialidadeBOProxy();
		
		
		try {
			Especialidade e;
			e = ebo.consultarEspecialidade(id);
			System.out.println(e.getNm_especialidade());
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		
	}

}
