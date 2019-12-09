package br.edu.fatec.salao.controller;

import java.util.List;

import br.edu.fatec.salao.DAO.ClienteDAO;
import br.edu.fatec.salao.model.entity.Cliente;
import br.edu.fatec.salao.model.enums.Genero;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ClienteController {
	
	public static ClienteController controller;
	
	public static ClienteController getInstance() {
		return controller == null 
				? new ClienteController()
				: controller;
	}
	
	public ClienteController criar(Cliente cliente) {
		ClienteDAO.getInstance().salvar(cliente);
		return this;
	}
	
	public List<Cliente> listar() {
		return ClienteDAO.getInstance().recuperaClientes();
	}
	
	public Cliente procurarPorId(long id) {
		return ClienteDAO.getInstance().procuraPorId(id);
	}
	
	public void editar(Cliente cliente) {
		ClienteDAO.getInstance().editar(cliente);
	}
	
	public void excluir(Cliente cliente) {
		ClienteDAO.getInstance().excluir(cliente);
	}
	
	public List<Cliente> listarPorGenero(Genero genero) {
		return ClienteDAO.getInstance().listarPorGenero(genero);
	}
	
}
