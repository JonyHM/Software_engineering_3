package br.edu.fatec.frameworkFinanceiro.service;

/**
 * Performs time related operations with its given milliseconds.
 * 
 * @author jonathasmoraes
 *
 */
public abstract class TimeDefiner {
	
	protected boolean isBr;
	
	/**
	 * Calculates how much time has been passed since the "time" argument until the time that this methos has been called.
	 * 
	 * @param time -> time to get the difference.
	 * @param next -> next entity on the chain.
	 * @return
	 */
	public abstract String calculateTimeDifference(long time, TimeDefiner next);
	
	/**
	 * Check if the prefered region is Brazil.
	 * @param BR -> boolean field that indicates if the region is Brazil.
	 * @return
	 */
	public TimeDefiner isBR(boolean BR) {
		this.isBr = BR;
		
		return this;
	}

}
