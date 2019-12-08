/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema.controller;

import Sistema.DAO.Conexao;
import Sistema.model.entity.Veiculo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Guilherme
 */
public class VeiculoController {

    Conexao cn = new Conexao();

    public VeiculoController() {

    }

    public void conecta() {
        cn.conecta();
    }

    public void desconecta() {
        cn.desconecta();
    }

    public void executaAtulizacao(String sql) {
        cn.executaAtualizacao(sql);
    }

    public void executeConsulta(String sql) {
        cn.executeConsulta(sql);
    }

    public List<Veiculo> getVeiculo(){
        List<Veiculo> veiculo = new ArrayList<>();
            
        try{
            while (cn.rs.next()) {
                veiculo.add(new Veiculo(
                    Long.valueOf(cn.rs.getString("cod_veiculo")),
                    cn.rs.getString("modelo"),
                    cn.rs.getString("placa"),
                    cn.rs.getString("ano"),
                    cn.rs.getString("valor"),
                    cn.rs.getString("proprietario")
                    )
                );
            }   
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar o banco de dados: " + ex);
        }
        
        return veiculo;
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
