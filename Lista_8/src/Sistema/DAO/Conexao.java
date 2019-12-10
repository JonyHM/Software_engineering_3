package Sistema.DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {

    private Connection conexao;

    private Statement st;

    public ResultSet rs;

    private final String url = "jdbc:firebirdsql:localhost/3050:/Users/Guilherme/Documents/NetBeansProjects/Lista_8/Lista_8.FDB";

    private final String driver = "org.firebirdsql.jdbc.FBDriver";

    private final String usuario = "sysdba";

    private final String senha = "masterkey";

    public void conecta() {
        try {
            Class.forName(this.driver);
            conexao = DriverManager.getConnection(this.url, this.usuario, this.senha);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel carregar o driver: " + ex);
        } catch (SQLException sqlEx) {
            JOptionPane.showMessageDialog(null, "Erro de conexao com o banco de dados: " + sqlEx);
        }
    }

    public void desconecta() {
        try {
            conexao.close();
        } catch (SQLException sqlEx) {
            JOptionPane.showMessageDialog(null, "Não foi possivel desconecta o banco: " + sqlEx);
        }
    }

    public void executaAtualizacao(String sql) {
        try {
            st = conexao.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException sqlEx) {
            JOptionPane.showMessageDialog(null, "Não foi spossivel executar o comando sql: " + sql + "Erro: " + sqlEx);
        }
    }

    public void executeConsulta(String sql) {
        try {
            st = conexao.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException sqlEx) {
            JOptionPane.showMessageDialog(null, "Não foi possivel executar o comando sql: " + "Erro: " + sqlEx);
        }
    }
}
