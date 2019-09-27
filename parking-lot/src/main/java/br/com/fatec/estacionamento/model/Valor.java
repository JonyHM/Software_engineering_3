package br.com.fatec.estacionamento.model;

public class Valor {

	private double valorHora;
	private double valorDia;
	private double valorMes;
	
	public Valor(double hora, double dia, double mes) {
		this.valorHora = hora;
		this.valorDia = dia;
		this.valorMes = mes;
	}
	
	public double getValorHora() {
		return valorHora;
	}
	public double getValorDia() {
		return valorDia;
	}
	public double getValorMes() {
		return valorMes;
	}
	
	
}
