package br.edu.fatec.salao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import br.edu.fatec.salao.controller.BemController;
import br.edu.fatec.salao.controller.ClienteController;
import br.edu.fatec.salao.controller.CompraController;
import br.edu.fatec.salao.controller.LojaController;
import br.edu.fatec.salao.model.entity.Bem;
import br.edu.fatec.salao.model.entity.Cliente;
import br.edu.fatec.salao.model.entity.Compra;
import br.edu.fatec.salao.model.entity.Loja;
import br.edu.fatec.salao.model.enums.Genero;
import br.edu.fatec.salao.model.enums.Tipo;

public class App {
    
	public static void main( String[] args ) throws ParseException {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
//-------------------------------------------------------------------------------------------------
// Criando lojas		

		Loja loja1 = Loja.builder()
				.unidade("São José dos Campos")
				.build();
		
//-------------------------------------------------------------------------------------------------
// Criando clientes
		
		Cliente cliente1 = Cliente.builder()
				.nome("José da Silva")
				.telefone("3456-7891")
				.dataNascimento(formatter.parse("21-03-1995"))
				.genero(Genero.MASCULINO)
				.build();
		
		Cliente cliente2 = Cliente.builder()
				.nome("Fernanda Castro")
				.telefone("3761-4652")
				.dataNascimento(formatter.parse("10-05-1998"))
				.genero(Genero.FEMININO)
				.build();
		
		Cliente cliente3 = Cliente.builder()
				.nome("Angela Fernandes")
				.telefone("3953-6541")
				.dataNascimento(formatter.parse("15-07-1993"))
				.genero(Genero.FEMININO)
				.build();
		
//-------------------------------------------------------------------------------------------------			
// Criando itens
			
		Bem modelagem = Bem.builder()
				.nome("Modelagem de barba")
				.valor(23.0)
				.tipo(Tipo.SERVICO)
				.build();
		
		Bem corteBarba = Bem.builder()
				.nome("Corte de barba")
				.valor(12.0)
				.tipo(Tipo.SERVICO)
				.build();
		
		Bem queda = Bem.builder()
				.nome("Tratamento para queda de cabelo")
				.valor(125.70)
				.tipo(Tipo.SERVICO)
				.build();
		
		Bem cremeBarba = Bem.builder()
				.nome("Creme pós barba")
				.valor(23.35)
				.tipo(Tipo.PRODUTO)
				.build();
		
		Bem pedicure = Bem.builder()
				.nome("Pedicure")
				.valor(15.30)
				.tipo(Tipo.SERVICO)
				.build();
		
		Bem design = Bem.builder()
				.nome("Design de Sobrancelhas")
				.valor(55.50)
				.tipo(Tipo.SERVICO)
				.build();
		
		Bem pintura = Bem.builder()
				.nome("Tingimento de cabelo")
				.valor(27.75)
				.tipo(Tipo.SERVICO)
				.build();
		
		Bem rugas = Bem.builder()
				.nome("Remoção de rugas")
				.valor(75.50)
				.tipo(Tipo.SERVICO)
				.build();
		
		Bem manchas = Bem.builder()
				.nome("Remoção de manchas")
				.valor(80.0)
				.tipo(Tipo.SERVICO)
				.build();
		
		Bem botox = Bem.builder()
				.nome("Aplicação de botox")
				.valor(125.5)
				.tipo(Tipo.SERVICO)
				.build();
		
		Bem emagrecimento = Bem.builder()
				.nome("Tratamento para emagrecimento")
				.valor(275.0)
				.tipo(Tipo.SERVICO)
				.build();
		
		Bem medidas = Bem.builder()
				.nome("Redução de medidas")
				.valor(127.20)
				.tipo(Tipo.SERVICO)
				.build();
		
		Bem corte = Bem.builder()
				.nome("Corte Masculino")
				.valor(12.25)
				.tipo(Tipo.SERVICO)
				.build();
		
		Bem shampoo = Bem.builder()
				.nome("Shampoo de cerveja")
				.valor(24.12)
				.tipo(Tipo.PRODUTO)
				.build();
		
		Bem corteFeminino = Bem.builder()
				.nome("Corte Feminino")
				.valor(27.30)
				.tipo(Tipo.SERVICO)
				.build();
		
		Bem hidratacao = Bem.builder()
				.nome("Hidratação")
				.valor(15.50)
				.tipo(Tipo.SERVICO)
				.build();
		
		Bem manicure = Bem.builder()
				.nome("Manicure")
				.valor(10.0)
				.tipo(Tipo.SERVICO)
				.build();
		
//-------------------------------------------------------------------------------------------------			      
// Persistindo Bens		
		
		BemController bemController = BemController.getInstance()
				.criar(corte).criar(cremeBarba).criar(modelagem).criar(medidas)
				.criar(emagrecimento).criar(manchas).criar(corteFeminino).criar(shampoo)
				.criar(hidratacao).criar(manicure).criar(corteBarba).criar(queda).criar(botox)
				.criar(pedicure).criar(design).criar(pintura).criar(rugas);
		
//-------------------------------------------------------------------------------------------------			      
// Criando Compras
		
		Compra compra1 = Compra.builder()
				.data(formatter.parse("10-11-2019"))
				.observacao("Se sobrar cabelo, platina tudo e confirma se posso beber o shampoo")
				.build();

		Compra compra2 = Compra.builder()
				.data(formatter.parse("15-11-2019"))
				.build();
		
		Compra compra3 = Compra.builder()
				.data(formatter.parse("16-11-2019"))
				.build();
		
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

		LojaController lojaController = LojaController.getInstance()
				.criar(loja1);
		
		ClienteController clienteController = ClienteController.getInstance()
				.criar(cliente1)
				.criar(cliente2)
				.criar(cliente3);
		
		CompraController compraController = CompraController.getInstance()
				.criar(compra1)
				.criar(compra2)
				.criar(compra3);
		
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
        System.out.println("-------------------------------------------------------------");
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
        System.out.println("-------------------------------------------------------------");
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
        System.out.println("-------------------------------------------------------------");
        List<Cliente> mulheres = clienteController.listarPorGenero(Genero.FEMININO);
        System.out.println(mulheres.size() + " mulheres cadastradas");
        mulheres.forEach(System.out::println);
        System.out.println("-------------------------------------------------------------");
        
//-------------------------------------------------------------------------------------------------        
// Relatórios
//        Qual é a idade média de todo o público de uma unidade.
//        Qual é a idade média do público para um determinado gênero.
//        Qual é o serviço mais procurado para todo o público.
//        Qual é o seriço mais procurado para um determinado gênero.
        
        System.out.println("\n");
        System.out.println("--------------------------------Idade média de uma unidade-----------------------------");
        Loja SJC = lojaController.pegarPorUnidade("São José dos Campos");
        List<Cliente> deSJC = SJC.getClientes(); 
        deSJC.forEach(System.out::println);
    }
}
