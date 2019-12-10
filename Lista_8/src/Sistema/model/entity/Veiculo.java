/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema.model.entity;


/**
 *
 * @author Guilherme
 */
public class Veiculo {
    
    private long id;
    private String modelo;
    private String placa;
    private String ano;
    private String valor;
    private String proprietario;
    
    public Veiculo(){
        
    }

    public Veiculo(long id, String modelo, String placa, String ano, String valor, String proprietario) {
        this.id = id;
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.valor = valor;
        this.proprietario = proprietario;
    }


    public long getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getAno() {
        return ano;
    }

    public String getValor() {
        return valor;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }
    
    
}
