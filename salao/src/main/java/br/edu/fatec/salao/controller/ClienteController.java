package br.edu.fatec.salao.controller;

import java.util.List;

import br.edu.fatec.salao.DAO.ClienteDAO;
import br.edu.fatec.salao.model.Cliente;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ClienteController {
	
	public static ClienteController controller;
	
	public static ClienteController getInstance() {
		return controller == null 
				? new ClienteController()
				: controller;
	}
	
	public void criar(Cliente cliente) {
		ClienteDAO.getInstance().salvar(cliente);
	}
	
	public List<Cliente> listar() {
		return ClienteDAO.getInstance().recuperaClientes();
	}
}
