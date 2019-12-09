package br.edu.fatec.salao.controller;

import java.util.List;

import br.edu.fatec.salao.DAO.BemDAO;
import br.edu.fatec.salao.model.entity.Bem;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BemController {

	public static BemController controller;
	
	public static BemController getInstance() {
		return controller == null 
				? new BemController()
				: controller;
	}
	
	public BemController criar(Bem bem) {
		BemDAO.getInstance().salvar(bem);
		return this;
	}
	
	public List<Bem> listar() {
		return BemDAO.getInstance().recuperaBens();
	}
	
	public Bem maisProcurado() {
		return BemDAO.getInstance().pegaTopServico();
	}
}
