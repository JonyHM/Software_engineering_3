package br.com.fatec.estacionamento.service;

import br.com.fatec.estacionamento.model.veiculo.Veiculo;

public abstract class CalculoValor {

	protected CalculoValor proximoCalculo;
	protected double valorParaCalculo;
	protected double valorFinal;
	protected long quantidadeTempo;
	protected long horasTotais;
	protected Veiculo veiculo;
	
	public abstract double calcular(long quantidadeTempo, CalculoValor proximoCalculo);
	public abstract double adicional(double valorParaCalculo);
}
