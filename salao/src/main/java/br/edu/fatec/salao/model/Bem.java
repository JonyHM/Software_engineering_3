package br.edu.fatec.salao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.Nullable;

import lombok.Builder;
import lombok.Data;

/**
 * 
 * @author Jonathas
 *
 */
@Data
@Entity
@Builder(toBuilder = true)
@Table(name = "BEM")
public class Bem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BEM_ID", nullable = false)
	private long id;
	
	@Column(name = "BEM_NOME", nullable = false)
	private String nome;
	
	@Column(name = "BEM_VALOR", nullable = false)
	private Double valor;
	
	@Column(name = "BEM_TIPO", nullable = false)
	private Tipo tipo;
	
	@Column(name = "BEM_DETALHES", nullable = true)
	@Nullable
	private String detalhes;
}
