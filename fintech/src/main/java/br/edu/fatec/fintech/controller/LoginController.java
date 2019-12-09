package br.edu.fatec.fintech.controller;

import br.edu.fatec.fintech.model.DAO.LoginDAO;
import br.edu.fatec.fintech.model.entity.Login;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LoginController {

	private LoginDAO dao = new LoginDAO();
	
	public void cadastrar(Login login) {
		dao.cadastrar(login);
	}
	
	public boolean signIn(String user, String pass) {
		Login login = dao.signIn(user, pass);
		
		return login != null;
	}
}
