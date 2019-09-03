package br.com.fatec.estacionamento.model.veiculo;

import br.com.fatec.estacionamento.model.Categoria;
import br.com.fatec.estacionamento.model.Valor;

public class Carga implements Veiculo {

	private int eixos = 1;
	private double valorCarga;
	private Categoria categoria;
	private Valor valorVeiculoCarga;
	
	public Carga(double valorCarga, int eixos) {
		this.valorVeiculoCarga = new Valor(4, 35, 200);
		this.eixos = eixos;
		this.valorCarga = valorCarga;
		this.categoria = Categoria.D;
	}
	
	public String getCategoria() {
		return this.categoria.toString();		
	}
	
	public double getValorCarga() {
		return this.valorCarga;
	}
	
	public int getEixos() {
		return this.eixos;
	}

	public Valor getValor() {
		return this.valorVeiculoCarga;
	}

	public int adicionalEixos() {
		return this.eixos;
	}

	public double adicionalCarga() {
		return ((this.valorCarga * 10) / 100);
	}
}
