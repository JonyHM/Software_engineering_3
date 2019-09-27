package br.com.fatec.estacionamento.service;

import br.com.fatec.estacionamento.model.veiculo.Veiculo;
import br.com.fatec.estacionamento.resource.HoraParaMili;
import br.com.fatec.estacionamento.resource.MiliParaHora;

public class ValorDia extends CalculoValor {

	private long quantidadeTempoDias;
	
	public ValorDia(Veiculo veiculo) {
		this.veiculo = veiculo;
		this.valorParaCalculo = veiculo.getValor().getValorDia();
	}

	@Override
	public double calcular(long horasTotais, CalculoValor proximoCalculo) {
		this.horasTotais = horasTotais;
		this.quantidadeTempo = MiliParaHora.transformarHoras(this.horasTotais);
		this.quantidadeTempoDias = MiliParaHora.transformarDias(this.horasTotais);
		
		if(this.quantidadeTempo > 12l && this.quantidadeTempoDias <= 15l) {
			return this.quantidadeTempoDias <= 1 
					? adicional(this.valorParaCalculo) 
					: (adicional(this.valorParaCalculo) * this.quantidadeTempoDias) + proximoCalculo
						.calcular(HoraParaMili.transformarDias(this.quantidadeTempo - 24l), new ValorFinal());
		} else {
			return proximoCalculo.calcular(this.horasTotais, new ValorFinal());
		}
	}
	
	@Override
	public double adicional(double valorParaCalculo) {
		return (valorParaCalculo * this.veiculo.adicionalEixos()) + this.veiculo.adicionalCarga();
	}
}
