/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema.view;

import Sistema.DAO.Conexao;
import Sistema.controller.VeiculoController;
import Sistema.model.entity.Veiculo;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Cad_Veiculos extends javax.swing.JFrame {

    //
    Conexao cn = new Conexao();
    VeiculoController controller = new VeiculoController();

    DefaultTableModel lista = new DefaultTableModel();    // Usa na MontLista
    //

    public void recupera_campos(int ar) {

        // teste da var AR
        switch (ar) {
            case 0: // vazio é consulta
                labFuncao.setText("");
                break;
            case 1:
                labFuncao.setText("Incluir");
                break;
            case 2:
                labFuncao.setText("Editar");
                break;
            //
            //defalult = essa função é o otherwise
        }

    }

    public void MontaLista() {

        lista.setColumnCount(0);
        lista.setRowCount(0);

        controller.conecta();
        String sql = "SELECT * FROM veiculos "
                + "WHERE UPPER(modelo) "
                + "LIKE '%" + "%'"
                + "ORDER BY cod_veiculo";
        // Clausula LIKE: com esta linha abaixo filtra o conteudo da cx. texto para cada letra digitada -> 
        // + "LIKE '%" + txtFis.getText().toUpperCase() + "%'"            

        controller.executeConsulta(sql);

        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  // Selecionar apenas um elemento da tabela
        jTable1.getTableHeader().setReorderingAllowed(false);  // Cabecalho nao reordenavel

        lista.addColumn("Cód");
        lista.addColumn("Modelo");
        lista.addColumn("Placa");
        lista.addColumn("Ano");
        lista.addColumn("Valor");
        lista.addColumn("Proprietário");
        jTable1.setModel(lista);

        jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
        jTable1.getColumnModel().getColumn(0).setResizable(false);

        jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(1).setResizable(false);

        jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(2).setResizable(false);

        jTable1.getColumnModel().getColumn(3).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(3).setResizable(false);

        jTable1.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(4).setResizable(false);

        jTable1.getColumnModel().getColumn(5).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(5).setResizable(false);

        jTable1.getTableHeader().setReorderingAllowed(false);

        List<Veiculo> veiculo = controller.getVeiculo();
        veiculo.forEach(vec ->{
            lista.addRow(new String[]{
                vec.getId() + "",
                vec.getModelo(),
                vec.getPlaca(),
                vec.getAno(),
                vec.getValor(),
                vec.getProprietario()
     
            });
        });
        lista.addColumn(veiculo);
        controller.desconecta();
        jTable1.setModel(lista);
    }

    public void Selecao() {

        int linha = jTable1.getSelectedRow();  // esta instrução pega o "numero da linha" da grade e coloca na var. "linha"
        // JOptionPane.showMessageDialog(null, "Linha: "+ linha);  // Libere esta instrução e veja o nume da linha da grade

        txtCodigo.setText(jTable1.getValueAt(linha, 0).toString());
        txtModelo.setText(jTable1.getValueAt(linha, 1).toString());
        txtPlaca.setText(jTable1.getValueAt(linha, 2).toString());
        txtAno.setText(jTable1.getValueAt(linha, 3).toString());
        txtValor.setText(jTable1.getValueAt(linha, 4).toString());
        comboProprietario.setSelectedItem(jTable1.getValueAt(linha, 5).toString());

    }

    public void preencherCombo() throws SQLException {

        controller.conecta();
        String sql = "Select * from Clientes "
                + "ORDER BY nome";

        List<String> colunas = controller.getColuna(sql, "nome");
        colunas.forEach(coluna -> {
            comboProprietario.addItem(coluna);
        });
        controller.desconecta();
    }
    

    public Cad_Veiculos() throws SQLException {
        initComponents();

        labTitulo.setText("Cadastros");  // Exemplo: Cadastros
        labTela.setText("Clientes");    // Exemplo: Clientes
        labFuncao.setText("");     // ->     Este define nos Botoes
        this.preencherCombo();
        MontaLista();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnSair = new javax.swing.JButton();
        btnMinimizar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        labTitulo = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        labTela = new javax.swing.JLabel();
        labFuncao = new javax.swing.JLabel();
        btnAlterar = new javax.swing.JButton();
        btnDesfazer = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnLocalizar = new javax.swing.JButton();
        btnGravar = new javax.swing.JButton();
        btnIncluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtValor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtAno = new javax.swing.JTextField();
        txtPlaca = new javax.swing.JTextField();
        Endereço = new javax.swing.JLabel();
        comboProprietario = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(155, 155, 155), 5));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(155, 155, 155));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setToolTipText("");
        jPanel2.setPreferredSize(new java.awt.Dimension(730, 30));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSair.setBackground(new java.awt.Color(172, 47, 5));
        btnSair.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnSair.setForeground(new java.awt.Color(255, 255, 255));
        btnSair.setText("x");
        btnSair.setToolTipText("Sair");
        btnSair.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jPanel2.add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 2, 27, 22));

        btnMinimizar.setBackground(new java.awt.Color(204, 102, 0));
        btnMinimizar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnMinimizar.setForeground(new java.awt.Color(255, 255, 255));
        btnMinimizar.setText("-");
        btnMinimizar.setToolTipText("Minimizar");
        btnMinimizar.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btnMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizarActionPerformed(evt);
            }
        });
        jPanel2.add(btnMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(676, 2, 27, 22));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Verdana", 1, 19)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(64, 108, 196));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("G&J");
        jLabel7.setAlignmentX(30.0F);
        jLabel7.setAlignmentY(20.0F);
        jLabel7.setAutoscrolls(true);
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel7.setOpaque(true);
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 4, 54, 18));

        labTitulo.setBackground(new java.awt.Color(255, 255, 255));
        labTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labTitulo.setForeground(new java.awt.Color(255, 255, 255));
        labTitulo.setText("Titulo");
        jPanel2.add(labTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 4, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 0, 745, 25));

        txtModelo.setBackground(new java.awt.Color(242, 248, 254));
        txtModelo.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtModelo.setForeground(new java.awt.Color(51, 102, 255));
        jPanel1.add(txtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 76, 120, 28));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel1.setText("Modelo/Versão");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, -1, -1));

        jPanel3.setBackground(new java.awt.Color(94, 138, 204));
        jPanel3.setToolTipText("");
        jPanel3.setPreferredSize(new java.awt.Dimension(730, 30));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labTela.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labTela.setForeground(new java.awt.Color(255, 255, 255));
        labTela.setText("Tela");
        jPanel3.add(labTela, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 4, -1, -1));

        labFuncao.setBackground(new java.awt.Color(242, 248, 254));
        labFuncao.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        labFuncao.setForeground(new java.awt.Color(255, 255, 0));
        jPanel3.add(labFuncao, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 3, 110, 21));

        btnAlterar.setBackground(new java.awt.Color(188, 218, 247));
        btnAlterar.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        btnAlterar.setForeground(new java.awt.Color(51, 102, 255));
        btnAlterar.setText("a");
        btnAlterar.setToolTipText("Editar");
        btnAlterar.setEnabled(false);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        jPanel3.add(btnAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 40, 28));

        btnDesfazer.setBackground(new java.awt.Color(188, 218, 247));
        btnDesfazer.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        btnDesfazer.setForeground(new java.awt.Color(51, 102, 255));
        btnDesfazer.setText("D");
        btnDesfazer.setToolTipText("Desfazer");
        btnDesfazer.setEnabled(false);
        btnDesfazer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesfazerActionPerformed(evt);
            }
        });
        jPanel3.add(btnDesfazer, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 40, 28));

        btnCancelar.setBackground(new java.awt.Color(188, 218, 247));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(51, 102, 255));
        btnCancelar.setText("c");
        btnCancelar.setToolTipText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel3.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 40, 28));

        btnLocalizar.setBackground(new java.awt.Color(188, 218, 247));
        btnLocalizar.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        btnLocalizar.setForeground(new java.awt.Color(51, 102, 255));
        btnLocalizar.setText("L");
        btnLocalizar.setToolTipText("Localizar");
        btnLocalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalizarActionPerformed(evt);
            }
        });
        jPanel3.add(btnLocalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, 40, 28));

        btnGravar.setBackground(new java.awt.Color(188, 218, 247));
        btnGravar.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        btnGravar.setForeground(new java.awt.Color(51, 102, 255));
        btnGravar.setText("S");
        btnGravar.setToolTipText("Gravar");
        btnGravar.setEnabled(false);
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });
        jPanel3.add(btnGravar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 40, 28));

        btnIncluir.setBackground(new java.awt.Color(188, 218, 247));
        btnIncluir.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        btnIncluir.setForeground(new java.awt.Color(51, 102, 255));
        btnIncluir.setText("I");
        btnIncluir.setToolTipText("Adicionar");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });
        jPanel3.add(btnIncluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 40, 28));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 25, 741, 27));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 690, 120));

        txtValor.setBackground(new java.awt.Color(242, 248, 254));
        txtValor.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtValor.setForeground(new java.awt.Color(51, 102, 255));
        jPanel1.add(txtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 76, 120, 28));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("Proprietário");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, -1, -1));

        txtCodigo.setBackground(new java.awt.Color(242, 248, 254));
        txtCodigo.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtCodigo.setForeground(new java.awt.Color(51, 102, 255));
        txtCodigo.setEnabled(false);
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 76, 60, 28));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setText("Código");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setText("Ano");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, -1, -1));

        txtAno.setBackground(new java.awt.Color(242, 248, 254));
        txtAno.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtAno.setForeground(new java.awt.Color(51, 102, 255));
        jPanel1.add(txtAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 76, 70, 28));

        txtPlaca.setBackground(new java.awt.Color(242, 248, 254));
        txtPlaca.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtPlaca.setForeground(new java.awt.Color(51, 102, 255));
        jPanel1.add(txtPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 76, 90, 28));

        Endereço.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        Endereço.setText("Numero Placa");
        jPanel1.add(Endereço, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, -1, -1));

        comboProprietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProprietarioActionPerformed(evt);
            }
        });
        jPanel1.add(comboProprietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 76, 180, 28));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel5.setText("Valor");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 290));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // botao [X]
        // this.dispose();  // só o dispose vai fechar tudo
        setVisible(false);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed

        setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if (!"".equals(txtCodigo.getText())) {
            controller.conecta();
            controller.executaAtulizacao(" UPDATE veiculos SET modelo = '" + txtModelo.getText() + "' WHERE cod_veiculo = '" + txtCodigo.getText() + "'");
            controller.executaAtulizacao(" UPDATE veiculos SET placa = '" + txtPlaca.getText() + "' WHERE cod_veiculo = '" + txtCodigo.getText() + "'");
            controller.executaAtulizacao(" UPDATE veiculos SET ano = '" + txtAno.getText() + "' WHERE cod_veiculo = '" + txtCodigo.getText() + "'");
            controller.executaAtulizacao(" UPDATE veiculos SET valor = '" + txtValor.getText() + "' WHERE cod_veiculo = '" + txtCodigo.getText() + "'");
            controller.executaAtulizacao(" UPDATE veiculos SET proprietario = '" + comboProprietario.getSelectedItem() + "' WHERE cod_veiculo = '" + txtCodigo.getText() + "'");

            controller.desconecta();
            MontaLista();
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnDesfazerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesfazerActionPerformed
        txtModelo.setText("");
        txtPlaca.setText("");
        txtAno.setText("");
        txtValor.setText("");
        btnAlterar.setEnabled(false);
        btnGravar.setEnabled(false);
        btnDesfazer.setEnabled(false);
    }//GEN-LAST:event_btnDesfazerActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLocalizarActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        if (!"".equals(txtModelo.getText()) && !"".equals(txtValor.getText())
                && !"".equals(txtValor.getText()) && !"".equals(txtAno.getText())) {

            String modelo = txtModelo.getText();
            String placa = txtPlaca.getText();
            String ano = txtAno.getText();
            String valor = txtValor.getText();
            String proprietario = comboProprietario.getSelectedItem().toString();

            controller.conecta();
            controller.executaAtulizacao("INSERT INTO veiculos "
                    + "(modelo, placa, ano, valor, proprietario)  VALUES ('"
                    + modelo + "','"
                    + placa + "','"
                    + ano + "','"
                    + valor + "','"
                    + proprietario + "')");

            controller.desconecta();
            MontaLista();

            btnAlterar.setEnabled(false);
            btnGravar.setEnabled(false);
            btnDesfazer.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
        }


    }//GEN-LAST:event_btnGravarActionPerformed

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        btnAlterar.setEnabled(true);
        btnGravar.setEnabled(true);
        btnDesfazer.setEnabled(true);

        txtModelo.setText("");
        txtPlaca.setText("");
        txtAno.setText("");
        txtValor.setText("");
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        Selecao();
    }//GEN-LAST:event_jTable1MouseClicked

    private void comboProprietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProprietarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboProprietarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cad_Veiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cad_Veiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cad_Veiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cad_Veiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Cad_Veiculos().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Cad_Veiculos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Endereço;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDesfazer;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnLocalizar;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox<String> comboProprietario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labFuncao;
    private javax.swing.JLabel labTela;
    private javax.swing.JLabel labTitulo;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
