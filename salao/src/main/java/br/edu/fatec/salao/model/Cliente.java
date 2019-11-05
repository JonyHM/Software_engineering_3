/**
 * 
 */
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.Nullable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jonathas
 *
 */
@Data
@Entity
@Builder(toBuilder = true)
@Table(name = "CLIENTE")
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CLI_ID", nullable = false)
	private long id;
	
	@Column(name = "CLI_NOME", nullable = false)
	private String nome;
	
	@Column(name = "CLI_TELEFONE", nullable = false)
	private String telefone;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CLI_DATA_NASC", nullable = false)
	private Calendar dataNascimento;
	
	@Column(name = "CLI_GENERO", nullable = true)
	@Nullable
	private Genero genero;
	
//	@Column(name = "CLI_COMPRAS")
//	@Nullable
//	@OneToMany(mappedBy = "CLIENTE", targetEntity = Compra.class, 
//		fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private List<String> compras;
}
