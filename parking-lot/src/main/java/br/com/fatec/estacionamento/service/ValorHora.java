package br.com.fatec.estacionamento.service;

import br.com.fatec.estacionamento.model.veiculo.Veiculo;
import br.com.fatec.estacionamento.resource.MiliParaHora;

public class ValorHora extends CalculoValor {
	
	public ValorHora(Veiculo veiculo) {
		this.valorParaCalculo = veiculo.getValor().getValorHora();
	}

	@Override
	public double calcular(long horasTotais, CalculoValor proximoCalculo) {
		this.horasTotais = horasTotais;
		this.quantidadeTempo = MiliParaHora.transformarHoras(this.horasTotais);
		
		if(this.quantidadeTempo < 12l) {
			return adicional(this.valorParaCalculo) * this.quantidadeTempo;
		} else {
			return proximoCalculo.calcular(this.horasTotais, new ValorFinal());
		}
	}

	@Override
	public double adicional(double valorParaCalculo) {
		return (valorParaCalculo * this.veiculo.adicionalEixos()) + this.veiculo.adicionalCarga();
	}

}
