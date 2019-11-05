package br.edu.fatec.salao;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import br.edu.fatec.salao.controller.BemController;
import br.edu.fatec.salao.controller.ClienteController;
import br.edu.fatec.salao.controller.CompraController;
import br.edu.fatec.salao.model.Bem;
import br.edu.fatec.salao.model.Cliente;
import br.edu.fatec.salao.model.Compra;
import br.edu.fatec.salao.model.Genero;
import br.edu.fatec.salao.model.Tipo;

public class App {
    
	public static void main( String[] args ) {
		
		// Criando data
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 9);
        calendar.set(Calendar.YEAR, 2015);
		
        // Criando cliente
		Cliente cliente = Cliente.builder()
				.nome("José da Silva")
				.telefone("3456-7891")
				.dataNascimento(calendar)
				.genero(Genero.MASCULINO)
//				.compras(Arrays.asList("Cabelin", "bigodin"))
				.build();
		
		
//		Bem bem = Bem.builder()
//				.nome("Corte Masculino")
//				.valor(12.25)
//				.tipo(Tipo.SERVICO)
//				.detalhes("Corte na máquina 0")
//				.build();
//				
//		// Criando data da compra
//		Calendar dataCompra = Calendar.getInstance();
//		calendar.set(Calendar.MONTH, Calendar.FEBRUARY);
//        calendar.set(Calendar.DAY_OF_MONTH, 10);
//        calendar.set(Calendar.YEAR, 2020);
//		        
//		Compra compra = Compra.builder()
//				.cliente(cliente)
//				.bens(Arrays.asList(bem))
//				.data(dataCompra)
//				.observacao("Se sobrar cabelo, platina tudo")
//				.build();
        
        // Persistindo cliente
        ClienteController.getInstance().criar(cliente);
        
//        // Persistindo compras
//        CompraController.getInstance().criar(compra);
//        
//        // Persistindo bens
//        BemController.getInstance().criar(bem);
//        
        // Listando clientes
        List<Cliente> clientes = ClienteController.getInstance().listar();
        clientes.forEach(c -> {
        	System.out.println(c.getNome());
        	System.out.println(c.getDataNascimento().getTime());
        });
        
//        // Listando compras
//        List<Compra> compras = CompraController.getInstance().listar();
//        compras.stream().forEach(System.out::println);
//        
//        // Listando bens        
//        List<Bem> bens = BemController.getInstance().listar(); 
//        bens.stream().forEach(System.out::println);
    }
}
