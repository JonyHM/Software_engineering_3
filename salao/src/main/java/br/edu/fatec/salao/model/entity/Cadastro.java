package br.edu.fatec.salao.model.entity;

import java.util.List;

import lombok.Data;

@Data
public class Cadastro {
	
	private long id;
	private List<Cliente> clientes;
	
	// remover builder dos campos que são obrigatórios
	// Compra te relacionamento fraco com cliente

}
