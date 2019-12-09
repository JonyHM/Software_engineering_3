package br.edu.fatec.fintech.controller;

import java.util.List;

import br.edu.fatec.fintech.model.DAO.UsuarioDAO;
import br.edu.fatec.fintech.model.entity.Movimentacao;
import br.edu.fatec.fintech.model.entity.Usuario;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UsuarioController {
	
	private UsuarioDAO dao = new UsuarioDAO();
//	private	Relatorio relatorio = new Relatorio();
	
	public void cadastrar(Usuario usuario) {
		dao.cadastrar(usuario);
	}
	
	public List<Usuario> listar() {
		return dao.listaUsuarios();
	}
	
	public List<Movimentacao> listaMovimentacoes() {
		return dao.listaMovimentacoes();
	}
	 
	public void relatorioMensal(int mes) {
		
	}
	
	public void relatorioSemanal(int semana, int mes) {
		
	}
}
