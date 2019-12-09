package br.edu.fatec.fintech;

import java.util.ArrayList;
import java.util.List;

import br.edu.fatec.fintech.controller.CaixaController;
import br.edu.fatec.fintech.controller.LoginController;
import br.edu.fatec.fintech.controller.RelatorioController;
import br.edu.fatec.fintech.controller.UsuarioController;
import br.edu.fatec.fintech.model.entity.Caixa;
import br.edu.fatec.fintech.model.entity.Login;
import br.edu.fatec.fintech.model.entity.Movimentacao;
import br.edu.fatec.fintech.model.entity.Usuario;
import br.edu.fatec.fintech.model.enums.Classificacao;
import br.edu.fatec.fintech.model.enums.Tipo;
import br.edu.fatec.fintech.resource.DateCalc;

public class App {
	
    public static void main( String[] args ) {
//-------------------------------------------------------------------------------------]
// Variáveis
    	
    	DateCalc dateCalc = new DateCalc();
    	CaixaController caixaController = new CaixaController();
    	LoginController loginController = new LoginController();
    	UsuarioController usuarioController = new UsuarioController();
    	RelatorioController relatorioController = new RelatorioController();
//-------------------------------------------------------------------------------------
    	
    	// CRIANDO DADOS
    	
//-------------------------------------------------------------------------------------
// Criando Login
    	
    	Login loginJao = new Login("jao", "123");    	
//-------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------
// Criando Caixa
    	
    	Caixa caixaJao = new Caixa();    	
//-------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------
// Criando Usuário
    	
    	Usuario jao = new Usuario("João Felipe", "3256-4976", "Rua dos Bobos, 0", 
    			"Jao.bobo@hotweels.com", loginJao, caixaJao); 
    	loginJao.setDono(jao);
    	caixaJao.setUsuario(jao);
//-------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------
// Criando Movimentação
    	
    	Movimentacao movimentacaoJao = new Movimentacao(Classificacao.ENTRADA, Tipo.SALARIO, "Salário Dezembro", 
    			2340.0, dateCalc.calc("29-11-2019", "dd-MM-yyyy"));
    	
    	Movimentacao saidaJao = new Movimentacao(Classificacao.SAIDA, Tipo.ENERGIA_ELETRICA, "Conta de Luz", 
    			312.0, dateCalc.calc("04-12-2019", "dd-MM-yyyy"));
//-------------------------------------------------------------------------------------
    	// PERSISTINDO DADOS
//-------------------------------------------------------------------------------------
// Persistindo Login
    	
    	loginController.cadastrar(loginJao);
//-------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------
// Atualizando caixa com uma nova movimentação
    	
    	caixaJao.addEntrada(movimentacaoJao).addSaida(saidaJao);
//-------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------
// Persistindo Caixa
    	
    	caixaController.cadastrar(caixaJao);
//-------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------
// Persistindo Usuário
    	
    	usuarioController.cadastrar(jao);
//-------------------------------------------------------------------------------------
    	// LISTANDO ENTIDADES
//-------------------------------------------------------------------------------------
// Usuários
    	List<Usuario> usuarios = usuarioController.listar();
    	usuarios.forEach(usuario -> {
    		System.out.println(usuario.getNome());
    	});
//-------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------
// LOGIN
    	boolean signIn = false;
//    	signIn = loginController.signIn("aa", "b");
    	signIn = loginController.signIn("jao", "123");
//-------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------
// Relatórios
    	
    	  if (signIn) {
			List<Movimentacao> movimentacoes = new ArrayList<>();
			movimentacoes = usuarioController.listaMovimentacoes();
			System.out.println("Mensal - Mês 11: \n");
			relatorioController.mensal(11, movimentacoes);
			System.out.println("\n\nSemanal - 1ª Semana do mês 11 (Não deve retornar nada): ");
			relatorioController.semanal(1, 11, movimentacoes);
			System.out.println("\n\nSemanal - 1ª Semana do mês 12: ");
			relatorioController.semanal(1, 12, movimentacoes);
		}
    }
}
