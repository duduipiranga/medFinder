package com.medfinder.teste;

import java.rmi.RemoteException;

import com.medfinder.bo.OperadoraBOProxy;
import com.medfinder.to.Operadora;

public class Teste2 {

	
	public static void main(String[] args) {
		int id = 12;
		
		OperadoraBOProxy ob = new OperadoraBOProxy();
		
		
		try {
			Operadora o;
			o = ob.consultarOperadora(id);
			System.out.println(o.getDs_operadora());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

	}

}
