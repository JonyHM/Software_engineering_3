package br.edu.fatec.frameworkFinanceiro.service;

import br.com.fatec.estacionamento.model.tempo.Dia;
import br.com.fatec.estacionamento.resource.MiliParaHora;

public class Year extends TimeDefiner {

	@Override
	public String calculateTimeDifference(long time, TimeDefiner next) {
		String response = "";
		long remainder = 0l;
		long years = MiliParaHora.transformarDias(time) / 365;
		
		if(years > 0l) {
			
			if(years > 1l) {
				response = this.isBr ? years + " anos " : years + " years ";
			} else {
				response = this.isBr ? years + " ano " : years + " year ";
			}
			
			remainder = time % (new Dia().getUnidade() * 365);
		} else {
			remainder = time;
		}
		
		return response + next.isBR(this.isBr).calculateTimeDifference(remainder, new Day());
	}

}
