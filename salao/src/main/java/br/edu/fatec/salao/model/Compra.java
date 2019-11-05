package br.edu.fatec.salao.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name = "COMPRA")
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COMP_ID", nullable = false)
	private long id;
	
	@Column(name = "COMP_CLI", nullable = false)
	@ManyToOne
	@JoinColumn(name = "CLI_ID")
	private Cliente cliente;
	
	@Column(name = "COMP_BEM", nullable = false)
	@OneToMany(mappedBy = "COMPRA", targetEntity = Bem.class,
			fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Bem> bens;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "COMP_DATA", nullable = false)
	private Calendar data;
	
	@Column(name = "COMP_OBS", nullable = true)
	@Nullable
	private String observacao;
}
