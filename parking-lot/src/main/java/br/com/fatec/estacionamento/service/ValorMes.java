package br.com.fatec.estacionamento.service;

import br.com.fatec.estacionamento.model.veiculo.Veiculo;
import br.com.fatec.estacionamento.resource.HoraParaMili;
import br.com.fatec.estacionamento.resource.MiliParaHora;

public class ValorMes extends CalculoValor {
	
	public ValorMes(Veiculo veiculo) {
		this.veiculo = veiculo;
		this.valorParaCalculo = veiculo.getValor().getValorMes();
	}

	@Override
	public double calcular(long horasTotais, CalculoValor proximoCalculo) {
		this.horasTotais = horasTotais;
		this.quantidadeTempo = MiliParaHora.transformarDias(this.horasTotais);
		
		if(this.quantidadeTempo > 15l) {
			return this.quantidadeTempo > 30 && (this.quantidadeTempo % 30) != 0 
					? (adicional(this.valorParaCalculo) * (this.quantidadeTempo / 30)) 
							+ proximoCalculo.calcular(
									HoraParaMili.transformarDias(this.quantidadeTempo % 30), 
									new ValorHora(this.veiculo)) 
					: adicional(this.valorParaCalculo);
		} else {
			return proximoCalculo.calcular(this.horasTotais, new ValorHora(this.veiculo));
		}
	}

	@Override
	public double adicional(double valorParaCalculo) {
		return (valorParaCalculo * this.veiculo.adicionalEixos()) + this.veiculo.adicionalCarga();
	}

}
