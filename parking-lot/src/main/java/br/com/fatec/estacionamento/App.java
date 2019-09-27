package br.com.fatec.estacionamento;

import java.util.Date;

import br.com.fatec.estacionamento.model.Categoria;
import br.com.fatec.estacionamento.model.veiculo.Carga;
import br.com.fatec.estacionamento.model.veiculo.Passeio;
import br.com.fatec.estacionamento.model.veiculo.Veiculo;
import br.com.fatec.estacionamento.resource.MiliParaHora;
import br.com.fatec.estacionamento.service.Conta;

public class App {

	public static void main(String[] args) {
		
		Veiculo carro = new Passeio(Categoria.B);
		Veiculo caminhao = new Carga(150.000, 3);
		
		Conta contaCarro = new Conta(carro);
		Conta contaCaminhao = new Conta(caminhao);
		
		contaCarro.iniciar();
		contaCaminhao.iniciar();
		
		contaCarro.finalizar(1568113500000l);
		contaCaminhao.finalizar(1568113500000l);
		
		System.out.println(new Date().getTime() - MiliParaHora.transformarDias(1568113500000l));
		
		System.out.println("Valor Carro: " + contaCarro.valorConta());
		System.out.println("Valor Caminhão: " + contaCaminhao.valorConta());
	}

}
