/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema.controller;

import Sistema.DAO.Conexao;
import Sistema.model.entity.Clientes;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Guilherme
 */
public class ClienteController {
    
    Conexao cn = new Conexao();
    
    public ClienteController(){
        
    }
    
    public void conecta(){
        cn.conecta();
    }
    
    public void desconecta(){
        cn.desconecta();
    }
    public void executaAtualizacao(String sql){
        cn.executaAtualizacao(sql);
    }
    
    public void executeConsulta(String sql){
        cn.executeConsulta(sql);
    }
    
    public List<Clientes> getClientes() {
        List<Clientes> clientes = new ArrayList<>();
        try {
            while (cn.rs.next()) {
                clientes.add(new Clientes(                    
                    Long.valueOf(cn.rs.getString("cod_cliente")),
                    cn.rs.getString("nome"),
                    cn.rs.getString("endereco"),
                    cn.rs.getString("telefone"),
                    cn.rs.getString("cpf"))
                );
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar o banco de dados: " + ex);
        }
        
        return clientes;
    }
}