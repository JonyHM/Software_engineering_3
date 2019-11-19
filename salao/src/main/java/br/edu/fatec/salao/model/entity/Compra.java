package br.edu.fatec.salao.model.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Jonathas
 *
 */
@Data
@Entity
@Builder(toBuilder = true)
@Table(name = "COMPRA")
@NoArgsConstructor
@AllArgsConstructor
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COMP_ID", nullable = false)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "COMP_CLI", foreignKey = @ForeignKey(name = "FK_CLIENTE"))
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "COMP_LOJA", foreignKey = @ForeignKey(name = "FK_LOJA"))
	private Loja loja;
	
	@Column(name = "COMP_BEM", nullable = false)
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@Builder.Default
	@Fetch(FetchMode.SUBSELECT)
	private Set<Bem> bens = new HashSet<>();
	
	@Column(name = "COMP_DATA", nullable = false, columnDefinition = "DATE")
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@Column(name = "COMP_OBS", nullable = true)
	private String observacao;
	
	@Builder.Default
	@Transient
	private SimpleDateFormat dateForm = new SimpleDateFormat("dd-MM-yyyy");
	
	/**
	 * Associa o bem à compra
	 * @param bem
	 */
	public void adicionarItem(Bem bem) {
		this.bens.add(bem);
	}
	
	/**
	 * Adiciona mais de um item à compra
	 * @param bens
	 */
	public void adicionarItens(List<Bem> bens) {
		this.bens.addAll(bens);
	}
	
	@Override
	public String toString() {
		this.observacao = this.observacao != null 
				? this.observacao
				: "";
		
		return "\nCliente: "+this.cliente.getNome()
				+ "\nData: " + dateForm.format(this.data.getTime())
				+ "\nObservações: " + this.observacao;
	}

}
