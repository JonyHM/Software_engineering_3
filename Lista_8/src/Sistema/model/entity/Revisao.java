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
public class Revisao {
 
    private long id;
    private String proprietario;
    private String veiculo;
    private String servico;
    private String data;
    
    public Revisao(){
        
    }

    public Revisao(long id, String proprietario, String veiculo, String servico, String data) {
        this.id = id;
        this.proprietario = proprietario;
        this.veiculo = veiculo;
        this.servico = servico;
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public String getProprietario() {
        return proprietario;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public String getServico() {
        return servico;
    }

    public String getData() {
        return data;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public void setData(String data) {
        this.data = data;
    }
     
}
