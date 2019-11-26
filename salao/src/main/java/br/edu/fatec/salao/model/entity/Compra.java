package br.edu.fatec.salao.model.entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "COMPRA")
@NoArgsConstructor
@RequiredArgsConstructor
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COMP_ID", nullable = false)
	private long id;
	
	@JoinColumn(name = "COMP_BEM")
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Bem> bens = new ArrayList<>();
	
	@Column(name = "COMP_DATA", nullable = false, columnDefinition = "DATE")
	@Temporal(TemporalType.DATE)
	@NonNull
	private Date data;
	
	@Column(name = "COMP_OBS", nullable = true)
	private String observacao = "";
	
	@Transient
	private SimpleDateFormat dateForm = new SimpleDateFormat("dd-MM-yyyy");
	
	public Compra(Date data, String observacao) {
		this.data = data;
		this.observacao = observacao;
	}
	
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
		return "\nData: " + dateForm.format(this.data.getTime())
				+ "\nObservações: " + this.observacao;
	}

}
