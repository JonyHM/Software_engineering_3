package br.edu.fatec.salao.model.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "CADASTRO")
@NoArgsConstructor
public class Cadastro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CAD_ID", nullable = false)
	private long id;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "CAD_CLIENTES", nullable = true)
	@ElementCollection
	private Set<Cliente> clientes = new HashSet<>();
	
	public void add(Cliente cliente) {
		this.clientes.add(cliente);
	}
	
	public void addAll(List<Cliente> clientes) {
		this.clientes.addAll(clientes);
	}
	
	@Override
	public String toString() {
		return "\nClientes: " + listarClientes();
	}

	private String listarClientes() {
		String lista = "";
		
		for (Cliente cliente : this.clientes) {
			lista += cliente.getNome() + " | ";
		}
		
		return lista;
	}
	
	// remover builder dos campos que são obrigatórios
	// Compra te relacionamento fraco com cliente

}
