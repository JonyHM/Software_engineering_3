package br.com.fatec.Revisao_carro.model.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Revisao {	
	
	private Cliente cliente;
	private Veiculo veiculo;
	private Date data;
	private String descricao;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");

	public Revisao() {
		
	}
	
	public Revisao(Cliente cliente, Veiculo veiculo, Date data, String descricao) {
		this.cliente = cliente;
		this.veiculo = veiculo;
		this.data = data;
		this.descricao = descricao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		return null;
		
	}
}
