package br.edu.fatec.salao.controller;

import br.edu.fatec.salao.DAO.LojaDAO;
import br.edu.fatec.salao.model.entity.Loja;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LojaController {

	public static LojaController controller;
	
	public static LojaController getInstance() {
		return controller == null 
				? new LojaController()
				: controller;
	}
	
	public LojaController criar(Loja loja) {
		LojaDAO.getInstance().salvar(loja);
		return this;
	}
	
	public Loja pegarPorUnidade(String unidade) {
		return LojaDAO.getInstance().pegarPorUnidade(unidade);
	}
}
