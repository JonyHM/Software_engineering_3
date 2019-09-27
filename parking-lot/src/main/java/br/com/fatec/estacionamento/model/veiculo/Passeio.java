package br.com.fatec.estacionamento.model.veiculo;

import br.com.fatec.estacionamento.model.Categoria;
import br.com.fatec.estacionamento.model.Valor;

public class Passeio implements Veiculo {
	
	private Categoria categoria;
	private Valor valorVeiculoPasseio;
	private Valor valorVeiculoTransporte;
	
	public Passeio(Categoria categoria) { 
		this.categoria = categoria;
		this.valorVeiculoPasseio = new Valor(2, 20, 100);
		this.valorVeiculoTransporte = new Valor(3, 25, 150);
	}

	public String getCategoria() {
		return this.categoria.toString();		
	}

	public Valor getValor() {
		return this.categoria == Categoria.D ? this.valorVeiculoTransporte : this.valorVeiculoPasseio;
	}

	
	public int adicionalEixos() {
		return 1;
	}

	
	public double adicionalCarga() {
		return 0;
	}
	
}
