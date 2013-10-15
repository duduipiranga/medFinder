package com.medfinder.teste;

import com.medfinder.dao.impl.ClienteDAO;
import com.medfinder.entity.Cliente;

public class Teste3 {
	
	public static void main(String[] args) {
		ClienteDAO cdao = new ClienteDAO();		
		boolean valido;
		
		
		valido = cdao.validarUsuario("uniplas@ig.com.br", "123456");
		
		System.out.println(valido);
		
		
	}

}
