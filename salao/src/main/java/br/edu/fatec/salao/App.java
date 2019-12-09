package br.edu.fatec.salao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.edu.fatec.salao.controller.BemController;
import br.edu.fatec.salao.controller.CadastroController;
import br.edu.fatec.salao.controller.ClienteController;
import br.edu.fatec.salao.controller.CompraController;
import br.edu.fatec.salao.controller.LojaController;
import br.edu.fatec.salao.model.entity.Bem;
import br.edu.fatec.salao.model.entity.Cadastro;
import br.edu.fatec.salao.model.entity.Cliente;
import br.edu.fatec.salao.model.entity.Compra;
import br.edu.fatec.salao.model.entity.Loja;
import br.edu.fatec.salao.model.enums.Genero;
import br.edu.fatec.salao.model.enums.Tipo;
import br.edu.fatec.salao.resource.ReportResource;

public class App {
    
	public static void main( String[] args ) throws ParseException {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

//-------------------------------------------------------------------------------------------------
// Criando lojas
		
		Cadastro cadastro = new Cadastro();
		
//-------------------------------------------------------------------------------------------------
// Criando lojas		

		Loja loja1 = new Loja("São José dos Campos", cadastro);
		
//-------------------------------------------------------------------------------------------------
// Criando clientes
		
		Cliente cliente1 = new Cliente("José da Silva", "3456-7891", formatter.parse("21-03-1995"), Genero.MASCULINO);
		Cliente cliente2 = new Cliente("Fernanda Castro", "3761-4652", formatter.parse("10-05-1998"), Genero.FEMININO);
		Cliente cliente3 = new Cliente("Angela Fernandes", "3953-6541", formatter.parse("15-07-1993"), Genero.FEMININO);
		
//-------------------------------------------------------------------------------------------------			
// Criando itens
			
		Bem modelagem = new Bem("Modelagem de barba", 23.0, Tipo.SERVICO);
//		Bem corteBarba = new Bem("Corte de barba", 12.0, Tipo.SERVICO);
//		Bem queda = new Bem("Tratamento para queda de cabelo", 125.70, Tipo.SERVICO);
		Bem cremeBarba = new Bem("Creme pós barba", 23.35, Tipo.PRODUTO);
//		Bem pedicure = new Bem("Pedicure", 15.30, Tipo.SERVICO);
//		Bem design = new Bem("Design de Sobrancelhas", 55.50, Tipo.SERVICO);
//		Bem pintura = new Bem("Tingimento de cabelo", 27.75, Tipo.SERVICO);
//		Bem rugas = new Bem("Remoção de rugas", 75.50, Tipo.SERVICO);
		Bem manchas = new Bem("Remoção de manchas", 80.0, Tipo.SERVICO);
//		Bem botox = new Bem("Aplicação de botox", 125.5, Tipo.SERVICO);
		Bem emagrecimento = new Bem("Tratamento para emagrecimento", 275.0, Tipo.SERVICO);
		Bem medidas = new Bem("Redução de medidas", 127.20, Tipo.SERVICO);
		Bem corte = new Bem("Corte Masculino", 12.25, Tipo.SERVICO);
		Bem shampoo = new Bem("Shampoo de cerveja", 24.12, Tipo.PRODUTO);
		Bem corteFeminino = new Bem("Corte Feminino", 27.30, Tipo.SERVICO);
		Bem hidratacao = new Bem("Hidratação", 15.50, Tipo.SERVICO);
		Bem manicure = new Bem("Manicure", 10.0, Tipo.SERVICO);
		
//-------------------------------------------------------------------------------------------------
// Persistindo Bens		
		
		BemController bemController = BemController.getInstance()
				.criar(corte).criar(cremeBarba).criar(modelagem).criar(medidas)
				.criar(emagrecimento).criar(manchas).criar(corteFeminino).criar(shampoo)
				.criar(hidratacao).criar(manicure);
		
//-------------------------------------------------------------------------------------------------			      
// Criando Compras
		
		Compra compra1 = new Compra(formatter.parse("10-11-2019"), "Se sobrar cabelo, platina tudo e confirma se posso beber o shampoo");
		Compra compra2 = new Compra(formatter.parse("15-11-2019"));
		Compra compra3 = new Compra(formatter.parse("16-11-2019"));
		
//-------------------------------------------------------------------------------------------------		
// Associando item à compra
		
		compra1.adicionarItens(Arrays.asList(corte, shampoo, cremeBarba, modelagem));		
		compra2.adicionarItens(Arrays.asList(corteFeminino, hidratacao, medidas, emagrecimento));
		compra3.adicionarItens(Arrays.asList(manicure, hidratacao, manchas));
		
//-------------------------------------------------------------------------------------------------
// Associando compra ao cliente
		
		cliente1.comprar(compra1);
		cliente2.comprar(compra2);
		cliente3.comprar(compra3);
		
//-------------------------------------------------------------------------------------------------
// Associando compras e clientes à loja
		
		loja1.adicionarClientes(Arrays.asList(cliente1, cliente2, cliente3));
		loja1.adicionarCompras(Arrays.asList(compra1, compra2, compra3));
		
//-------------------------------------------------------------------------------------------------		
// Persistindo lojas, clientes e Compras
		
		CompraController compraController = CompraController.getInstance()
				.criar(compra1)
				.criar(compra2)
				.criar(compra3);
		
		ClienteController clienteController = ClienteController.getInstance()
				.criar(cliente1)
				.criar(cliente2)
				.criar(cliente3);
		
		CadastroController.getInstance().criar(cadastro);

		LojaController lojaController = LojaController.getInstance()
				.criar(loja1);
		
//-------------------------------------------------------------------------------------------------        
// Listagem
		
		System.out.println("--------------------Listando Clientes-----------------------");
// Listando clientes
        List<Cliente> clientes = clienteController.listar();
        System.out.println(clientes.size() + " clientes cadastrados");
        clientes.forEach(System.out::println);
        System.out.println("-------------------------------------------------------------");
        
        System.out.println("\n");
        
        System.out.println("--------------------Listando Compras-----------------------");
// Listando compras
        List<Compra> compras = compraController.listar();
        compras.forEach(System.out::println);
        System.out.println("-------------------------------------------------------------");
        
        System.out.println("\n");        
        
        System.out.println("----------------------Listando Bens-----------------------");
// Listando bens        
        List<Bem> bens = bemController.listar();
        System.out.println("bens: " + bens.size());
        bens.forEach(System.out::println);
        System.out.println("-------------------------------------------------------------");
//-------------------------------------------------------------------------------------------------        
// Editando cadastro
        
        System.out.println("\n");
        System.out.println("------------------------------Editando cadastro-------------------------------");
        System.out.println("Editando");
        
        Cliente clienteAEditar = clienteController.procurarPorId(1l);        
        System.out.println("Antes: " + clienteAEditar.getNome());
        
        clienteAEditar.setNome("José Francisco da Silva");        
        clienteController.editar(clienteAEditar);
        
        Cliente clienteEditado = clienteController.procurarPorId(1l);        
        System.out.println("Depois: " + clienteEditado.getNome());
        System.out.println("-------------------------------------------------------------");   

//-------------------------------------------------------------------------------------------------        
// Excluindo cadastro
        
        System.out.println("\n");
        System.out.println("---------------------------Excluindo cadastro----------------------------------");
        System.out.println("Antes");
        
        List<Cliente> total = clienteController.listar();
        System.out.println(total.size() + " clientes cadastrados");
        total.forEach(System.out::println);
        
        System.out.println("\n");
        System.out.println("Excluindo");
        
        Cliente aExcluir = clienteController.procurarPorId(1l);
        clienteController.excluir(aExcluir);

        System.out.println("\n");
        System.out.println("depois");
        
        List<Cliente> depois = clienteController.listar();
        System.out.println(depois.size() + " clientes cadastrados");
        depois.forEach(System.out::println);
        System.out.println("-------------------------------------------------------------");
        
//-------------------------------------------------------------------------------------------------        
// Listando mulheres
        
        System.out.println("\n");
        System.out.println("-------------------------Listando mulheres------------------------------------");
        List<Cliente> mulheres = clienteController.listarPorGenero(Genero.FEMININO);
        System.out.println(mulheres.size() + " mulheres cadastradas");
        mulheres.forEach(System.out::println);
        System.out.println("-------------------------------------------------------------");
        
//-------------------------------------------------------------------------------------------------        
// Relatórios
//Idade média de uma unidade
        
        System.out.println("\n");
        System.out.println("--------------------------------Idade média de uma unidade-----------------------------");
        Loja SJC = lojaController.pegarPorUnidade("São José dos Campos");
        Set<Cliente> deSJC = SJC.getCadastros().getClientes(); 
        Double media = ReportResource.average(deSJC);
        System.out.println("Média de idade de clientes" + media);
        System.out.println("-----------------------------------------------------------------------------------------");

//-------------------------------------------------------------------------------------------------
//Idade média de um gênero
        
        System.out.println("\n");
        System.out.println("--------------------------------Idade média de um gênero-----------------------------");
        List<Cliente> feminino = clienteController.listarPorGenero(Genero.FEMININO);
        Double mediaFeminina = ReportResource.average(new HashSet<Cliente>(feminino));
        System.out.println("Média de idade de Mulheres" + mediaFeminina);
        System.out.println("-----------------------------------------------------------------------------------------");
        
//--------------------------------------------------------------------------------------------------
//Serviço mais procurado        
        
//        System.out.println("\n");
//        System.out.println("--------------------------------Serviço mais procurado-----------------------------");
//        Bem maisProcutado = bemController.maisProcurado();
//        System.out.println(maisProcutado);
//        System.out.println("-----------------------------------------------------------------------------------------");
//--------------------------------------------------------------------------------------------------        
//      Qual é o serviço mais procurado para um determinado gênero.
    }
}
