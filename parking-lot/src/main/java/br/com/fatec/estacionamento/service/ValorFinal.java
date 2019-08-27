package br.com.fatec.estacionamento.service;

public class ValorFinal extends CalculoValor {
	
	@Override
	public double calcular(long horas, CalculoValor proximoCalculo) {
		return 0;
	}

	@Override
	public double adicional(double valorParaCalculo) {
		return 0;
	}

}
