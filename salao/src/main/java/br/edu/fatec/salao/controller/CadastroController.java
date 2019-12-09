package br.edu.fatec.salao.controller;

import br.edu.fatec.salao.DAO.CadastroDAO;
import br.edu.fatec.salao.model.entity.Cadastro;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CadastroController {

public static CadastroController controller;
	
	public static CadastroController getInstance() {
		return controller == null 
				? new CadastroController()
				: controller;
	}
	
	public CadastroController criar(Cadastro cadastro) {
		CadastroDAO.getInstance().salvar(cadastro);
		return this;
	}
}
