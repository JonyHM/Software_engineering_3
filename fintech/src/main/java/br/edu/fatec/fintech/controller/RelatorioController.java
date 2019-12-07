package br.edu.fatec.fintech.controller;

import java.util.List;

import br.edu.fatec.fintech.model.entity.Movimentacao;
import br.edu.fatec.fintech.resource.Relatorio;

public class RelatorioController {

	Relatorio relatorio = new Relatorio();
	
	public void mensal(int mes, List<Movimentacao> todasMovimentacoes) {
		relatorio.mensal(mes, todasMovimentacoes);
	}
	
	public void semanal(int semana, int mes, List<Movimentacao> todasMovimentacoes) {
		relatorio.semanal(semana, mes, todasMovimentacoes);
	}
}
