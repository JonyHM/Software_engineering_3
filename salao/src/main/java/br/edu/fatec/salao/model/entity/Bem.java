package br.edu.fatec.salao.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.edu.fatec.salao.model.enums.Tipo;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author Jonathas
 *
 */
@Data
@Entity	
@Table(name = "BEM")
@NoArgsConstructor
@RequiredArgsConstructor
public class Bem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BEM_ID", nullable = false)
	private long id;
	
	@Column(name = "BEM_NOME", nullable = false)
	@NonNull
	private String nome;
	
	@Column(name = "BEM_VALOR", nullable = false)
	@NonNull
	private Double valor;
	
	@Column(name = "BEM_TIPO", nullable = false)
	@Enumerated(EnumType.STRING)
	@NonNull
	private Tipo tipo;
	
	
	@Override
	public String toString() {
		return "\nNome: " + this.nome
				+ "\nTipo: " + this.tipo.toString()
				+ "\nValor: R$" + this.valor;
	}

}
