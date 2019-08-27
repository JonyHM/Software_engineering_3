package br.edu.fatec.model;

import java.util.ArrayList;
import java.util.List;

public class ProdutoComposto extends Produto {
	
	private List<ProdutoUnitario> listaProdutos = new ArrayList<>();

	public ProdutoComposto(List<ProdutoUnitario> listaProdutos) {
		this.listaProdutos.addAll(listaProdutos);
	}

}
