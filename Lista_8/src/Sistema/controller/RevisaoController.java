/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema.controller;

import Sistema.DAO.Conexao;
import Sistema.model.entity.Revisao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Guilherme
 */
public class RevisaoController {
    
    Conexao cn = new Conexao();

    public RevisaoController() {
    }
    
    public void conecta() {
        cn.conecta();
    }
 
    public void executeConsulta(String sql) {
        cn.executeConsulta(sql);
    }
    
    public void executaAtualizacao(String sql) {
        cn.executaAtualizacao(sql);
    }
    
    public void desconecta() {
        cn.desconecta();
    }
    
    public List<Revisao> getRevisoes() {
        List<Revisao> revisoes = new ArrayList<>();
        
        try {
            while (cn.rs.next()) {
                revisoes.add(new Revisao(                    
                    Long.valueOf(cn.rs.getString("cod_revisao")),
                    cn.rs.getString("proprietario"),
                    cn.rs.getString("veiculo"),
                    cn.rs.getString("servico"),
                    cn.rs.getString("data"))
                );
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar o banco de dados: " + ex);
        }
        
        return revisoes;
    }
    
    public List<String> getColuna(String sql, String string) {
        List<String> retorno = new ArrayList<>();
        
        try {

            cn.executeConsulta(sql);

            while (cn.rs.next()) {
                retorno.add(cn.rs.getString(string));
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        
        return retorno;
    }
}
