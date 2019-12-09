package br.edu.fatec.fintech.controller;

import br.edu.fatec.fintech.model.DAO.MovimentacaoDAO;
import br.edu.fatec.fintech.model.entity.Movimentacao;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MovimentacaoController {

	private MovimentacaoDAO dao = new MovimentacaoDAO();
	
	public void cadastrar(Movimentacao movimentacao) {
		dao.cadastrar(movimentacao);
	}
}
