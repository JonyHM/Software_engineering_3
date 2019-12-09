package br.edu.fatec.fintech.model.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Caixa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CAIXA_ID")
	private long id;
	
	@OneToOne(mappedBy = "caixa")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "caixa", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Movimentacao> entradas = new HashSet<>();
	
	@OneToMany(mappedBy = "caixa", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Movimentacao> saidas = new HashSet<>();
	
	public Caixa addEntrada(Movimentacao entrada) {
		this.entradas.add(entrada);
		entrada.setCaixa(this);
		return this;
	}
	
	public Caixa addSaida(Movimentacao saida) {
		this.saidas.add(saida);
		saida.setCaixa(this);
		return this;
	}
	
	public Caixa addEntradas(List<Movimentacao> entradas) {
		this.entradas.addAll(entradas);
		return this;
	}
	
	public Caixa addSaidas(List<Movimentacao> saidas) {
		this.saidas.addAll(saidas);
		return this;
	}
	
	@Override
	public String toString() {
		return "Caixa";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Caixa other = (Caixa) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	
	
}
