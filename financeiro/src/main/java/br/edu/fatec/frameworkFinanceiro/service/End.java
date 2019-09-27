package br.edu.fatec.frameworkFinanceiro.service;

public class End extends TimeDefiner {

	@Override
	public String calculateTimeDifference(long time, TimeDefiner next) {
		return this.isBr ? "atrás" : "ago";
	}

}
