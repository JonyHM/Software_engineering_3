package br.com.fatec.Revisao_carro.model.entity;

public class Veiculo {
	
	private String placa;
	private String modelo;
	private String ano;
	private double valor;
	
	public Veiculo() {
		
	}
	
	public Veiculo(String placa, String modelo, String ano, double valor) {
		this.placa = placa;
		this.modelo = modelo;
		this.ano = ano;
		this.valor = valor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
}
