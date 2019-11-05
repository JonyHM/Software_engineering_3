package br.edu.fatec.salao.controller;

import java.util.List;

import br.edu.fatec.salao.DAO.CompraDAO;
import br.edu.fatec.salao.model.Compra;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CompraController {

public static CompraController controller;
	
	public static CompraController getInstance() {
		return controller == null 
				? new CompraController()
				: controller;
	}
	
	public void criar(Compra compra) {
		CompraDAO.getInstance().salvar(compra);
	}
	
	public List<Compra> listar() {
		return CompraDAO.getInstance().recuperaCompras();
	}
}
