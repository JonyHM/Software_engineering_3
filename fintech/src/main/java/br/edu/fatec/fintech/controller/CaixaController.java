package br.edu.fatec.fintech.controller;

import br.edu.fatec.fintech.model.DAO.CaixaDAO;
import br.edu.fatec.fintech.model.entity.Caixa;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CaixaController {

	private CaixaDAO dao = new CaixaDAO();
	
	public void cadastrar(Caixa caixa) {
		dao.cadastrar(caixa);
	}
	
	public void atualizar(Caixa caixa) {
		dao.atualizar(caixa);
	}
}
