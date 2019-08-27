package br.com.fatec.estacionamento.model.veiculo;

import br.com.fatec.estacionamento.model.Valor;

public interface Veiculo {

	public Valor getValor();
	public int adicionalEixos();
	public double adicionalCarga();
}
