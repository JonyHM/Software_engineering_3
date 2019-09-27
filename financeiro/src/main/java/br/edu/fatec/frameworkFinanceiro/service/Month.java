package br.edu.fatec.frameworkFinanceiro.service;

import br.com.fatec.estacionamento.model.tempo.Dia;
import br.com.fatec.estacionamento.resource.MiliParaHora;

public class Month extends TimeDefiner {

	@Override
	public String calculateTimeDifference(long time, TimeDefiner next) {
		String response = "";
		long remainder = 0l;
		long months = MiliParaHora.transformarDias(time) / 30;
		
		if(months > 0l) {
			
			if(months > 1l) {
				response = this.isBr ? months + " meses " : months + " months ";
			} else {
				response = this.isBr ? months + " mês " : months + " month ";
			}
			
			remainder = time % (new Dia().getUnidade() * 30);
		} else {
			remainder = time;
		}
		
		return response + next.isBR(this.isBr).calculateTimeDifference(remainder, new Hour());
	}

}
