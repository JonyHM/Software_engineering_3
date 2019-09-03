package br.com.fatec.estacionamento;

import br.com.fatec.estacionamento.model.Categoria;
import br.com.fatec.estacionamento.model.veiculo.Carga;
import br.com.fatec.estacionamento.model.veiculo.Passeio;
import br.com.fatec.estacionamento.model.veiculo.Veiculo;
import br.com.fatec.estacionamento.service.Conta;

public class App {

	public static void main(String[] args) {
		
		Veiculo carro = new Passeio(Categoria.B);
		Veiculo caminhao = new Carga(150.000, 3);
		
		Conta contaCarro = new Conta(carro);
		Conta contaCaminhao = new Conta(caminhao);
		
		contaCarro.iniciar();
		contaCaminhao.iniciar();
		
		contaCarro.finalizar(1567652400000l);
		contaCaminhao.finalizar(1567652400000l);
		
		System.out.println("Valor Carro: " + contaCarro.valorConta());
		System.out.println("Valor Caminhão: " + contaCaminhao.valorConta());
	}

}
