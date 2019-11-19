package br.edu.fatec.salao.model.entity;

import java.util.ArrayList;
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
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder(toBuilder = true)
@Table(name = "LOJA")
@NoArgsConstructor
@AllArgsConstructor
public class Loja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOJA_ID", nullable = false)
	private long id;
	
	@Column(name = "LOJA_UNIDADE")
	private String unidade;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@Column(name = "LOJA_CLIENTES", nullable = true)
	@Builder.Default
	@Fetch(FetchMode.SUBSELECT)
	private List<Cliente> clientes = new ArrayList<>();
	
	@Column(name = "LOJA_COMPRAS", nullable = true)
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "loja")
	@Builder.Default
	@Fetch(FetchMode.SUBSELECT)
	private Set<Compra> compras = new HashSet<>();
	
	/**
	 * Cadastra um cliente na loja
	 * @param cliente
	 */
	public void adicionarCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}
	
	/**
	 *  Cadastra mais de um cliente na loja 
	 * @param clientes
	 */
	public void adicionarClientes(List<Cliente> clientes) {
		this.clientes.addAll(clientes);
	}
	
	/**
	 * Cadastra compra na loja
	 * @param compra
	 */
	public void adicionarCompra(Compra compra) {
		this.compras.add(compra);
		compra.setLoja(this);
	}
	
	/**
	 * Cadastra mais de uma compra na loja
	 * @param compras
	 */
	public void adicionarCompras(List<Compra> compras) {
		this.compras.addAll(compras);
		compras.forEach(compra -> {
			compra.setLoja(this);
		});
	}
	
	@Override
	public String toString() {
		return "\nUnidade: " + this.unidade
				+ "\nClientes registrados: " + this.clientes.size()
				+ "\nCompras registradas: " + this.compras.size();
	}
	
}
