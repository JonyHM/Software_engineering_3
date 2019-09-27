package br.edu.fatec.frameworkFinanceiro.service;

import br.com.fatec.estacionamento.model.tempo.Dia;
import br.com.fatec.estacionamento.resource.MiliParaHora;

public class Hour extends TimeDefiner {

	@Override
	public String calculateTimeDifference(long time, TimeDefiner next) {
		String response = "";
		long remainder = 0l;
		long hours = MiliParaHora.transformarHoras(time);
		
		if(hours > 0l) {
			
			if(hours > 1l) {
				response = this.isBr ? hours + " horas " : hours + " hours ";
			} else {
				response = this.isBr ? hours + " hora " : hours + " hour ";
			}
			
			remainder = time % new Dia().getUnidade();
		} else {
			remainder = time;
		}
		
		return response + next.isBR(this.isBr).calculateTimeDifference(remainder, new End());
	}

}
