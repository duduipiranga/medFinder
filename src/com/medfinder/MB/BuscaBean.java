package com.medfinder.MB;

import java.util.ArrayList;
import java.util.List;

public class BuscaBean {

	private String cidade;
	private String bairro;
	
	public List<String> complete(String query) {
		System.out.println("Entrou");
		List<String> results = new ArrayList<String>();

		for (int i = 0; i < 10; i++) {
			results.add(query + i);
		}

		return results;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

}
