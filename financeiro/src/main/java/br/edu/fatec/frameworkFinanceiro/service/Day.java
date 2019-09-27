package br.edu.fatec.frameworkFinanceiro.service;

import br.com.fatec.estacionamento.model.tempo.Dia;
import br.com.fatec.estacionamento.resource.MiliParaHora;

public class Day extends TimeDefiner {

	@Override
	public String calculateTimeDifference(long time, TimeDefiner next) {
		String response = "";
		long remainder = 0l;
		long days = MiliParaHora.transformarDias(time);
		
		if(days > 0l) {
			
			if(days > 1l) {
				response = this.isBr ? days + " dias " : days + " days ";
			} else {
				response = this.isBr ? days + " dia " : days + " day ";
			}
			
			remainder = time % new Dia().getUnidade();
		} else {
			remainder = time;
		}
		
		return response + next.isBR(this.isBr).calculateTimeDifference(remainder, new End());
	}

}
