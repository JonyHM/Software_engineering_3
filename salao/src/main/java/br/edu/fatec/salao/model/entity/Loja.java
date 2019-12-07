package br.edu.fatec.salao.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "LOJA")
@NoArgsConstructor
@RequiredArgsConstructor
public class Loja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOJA_ID", nullable = false)
	private long id;
	
	@Column(name = "LOJA_UNIDADE")
	@NonNull
	private String unidade;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "LOJA_CADASTROS", nullable = true)
	@NonNull
	private Cadastro cadastros;
	
	@JoinColumn(name = "LOJA_COMPRAS", nullable = true)
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@ElementCollection
	private List<Compra> compras = new ArrayList<>();
	
	/**
	 * Cadastra um cliente na loja
	 * @param cliente
	 */
	public void adicionarCliente(Cliente cliente) {
		this.cadastros.add(cliente);
	}
	
	/**
	 *  Cadastra mais de um cliente na loja 
	 * @param clientes
	 */
	public void adicionarClientes(List<Cliente> clientes) {
		this.cadastros.addAll(clientes);
	}
	
	/**
	 * Cadastra compra na loja
	 * @param compra
	 */
	public void adicionarCompra(Compra compra) {
		this.compras.add(compra);
	}
	
	/**
	 * Cadastra mais de uma compra na loja
	 * @param compras
	 */
	public void adicionarCompras(List<Compra> compras) {
		this.compras.addAll(compras);
	}
	
	@Override
	public String toString() {
		return "\nUnidade: " + this.unidade
				+ "\nClientes registrados: " + this.cadastros.getClientes().size()
				+ "\nCompras registradas: " + this.compras.size();
	}
	
}
