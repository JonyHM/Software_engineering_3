package br.com.fatec.agro.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Animal {

	protected String breed;
	protected double weight;
	protected double kgValue;
	
}
