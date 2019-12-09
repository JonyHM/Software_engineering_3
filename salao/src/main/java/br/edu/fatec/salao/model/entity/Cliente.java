/**
 * 
 */
package br.edu.fatec.salao.model.entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import br.edu.fatec.salao.model.enums.Genero;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Jonathas
 *
 */
@Data
@Entity
@Table(name = "CLIENTE")
@NoArgsConstructor
@RequiredArgsConstructor
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CLI_ID", nullable = false)
	private long id;
	
	@Column(name = "CLI_NOME", nullable = false)
	@NonNull
	private String nome;
	
	@Column(name = "CLI_TELEFONE", nullable = false)
	@NonNull
	private String telefone;
	
	@Column(name = "CLI_DATA_NASC", nullable = false, columnDefinition = "DATE")
	@Temporal(TemporalType.DATE)
	@NonNull
	private Date dataNascimento;
	
	@Column(name = "CLI_GENERO", nullable = true)
	@Enumerated(EnumType.STRING)
	@NonNull
	private Genero genero;
	
	@JoinColumn(name = "CLI_COMPRAS")
	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	@ElementCollection
	private List<Compra> compras = new ArrayList<>();
	
	@Transient
	private SimpleDateFormat dateForm = new SimpleDateFormat("dd-MM-yyyy");
	
	/**
	 * Associa compra ao cliente
	 * @param compra
	 */
	public void comprar(Compra compra) {
		this.compras.add(compra);
	}
	
	private String listaProdutos() {	
		String lista = "Itens - ";
		
		for (Compra compra : this.compras) {
			for (Bem bem : compra.getBens()) {
				lista += bem.getNome() + " | ";
			}
		}
		
		return lista;
	}
	
	@Override
	public String toString() {
		return "\nNome: " + this.nome
				+ "\nTelefone: " + this.telefone
				+ "\nCompras realizadas (" + this.compras.size()
				+ ") \n\t" + listaProdutos();
	}

}
