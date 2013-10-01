package com.medfinder.teste;

import java.util.ArrayList;
import java.util.List;

import com.medfinder.dao.impl.ClienteDAO;
import com.medfinder.entity.Cliente;

public class Teste5 {
	
	public static void main(String[] args) {
		
		ClienteDAO cdao = new ClienteDAO();
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		clientes = cdao.listAll();
		
		for (Cliente cliente : clientes) {
			System.out.println("Nome: "+cliente.getNome()+"  RG: "+cliente.getId_cliente()+" - Endereço: "+cliente.getEndereco().getLogradouro() + cliente.getEndereco().getId_endereco()+" - Plano de saude : "+cliente.getPlano().getDs_plano() );
		}
		
	}
	

}
