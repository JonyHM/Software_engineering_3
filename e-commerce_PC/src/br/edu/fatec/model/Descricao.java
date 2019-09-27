package br.edu.fatec.model;

public class Descricao {
	
	private String modelo;
	private String marca;
	private String peso;
	private String tamanho;
	private String detalhes;
	
	public Descricao(String modelo, String marca,
			String peso, String tamanho, String detalhes) {
		
		this.modelo = modelo;
		this.marca = marca;
		this.peso = peso;
		this.tamanho = tamanho;
		this.detalhes = detalhes;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}
	
	@Override
	public String toString() {
		return ' ' + this.marca + ' ' + this.modelo + '\n' 
				+ "Peso: " + this.peso + "\nTamanho: " + this.tamanho + "\nEspecificações: " + this.detalhes;
	}
}
