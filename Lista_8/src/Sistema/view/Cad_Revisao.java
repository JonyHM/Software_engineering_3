/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema.view;

import Sistema.controller.RevisaoController;
import Sistema.model.entity.Revisao;
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
public class Cad_Revisao extends javax.swing.JFrame {
    
    RevisaoController controller = new RevisaoController();
    DefaultTableModel lista = new DefaultTableModel();    // Usa na MontLista

    public void MontaLista() {

        lista.setColumnCount(0);
        lista.setRowCount(0);
        controller.conecta();
        
        String sql = "SELECT * FROM revisao "
                + "ORDER BY cod_revisao";
        // Clausula LIKE: com esta linha abaixo filtra o conteudo da cx. texto para cada letra digitada -> 
        // + "LIKE '%" + txtFis.getText().toUpperCase() + "%'"           

        controller.executeConsulta(sql);
        
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  // Selecionar apenas um elemento da tabela
        jTable1.getTableHeader().setReorderingAllowed(false);  // Cabecalho nao reordenavel

        lista.addColumn("Cód");
        lista.addColumn("Proprietário");
        lista.addColumn("Veículo");
        lista.addColumn("Serviço");
        lista.addColumn("Data");
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

        jTable1.getTableHeader().setReorderingAllowed(false);

        List<Revisao> revisoes = controller.getRevisoes();
        revisoes.forEach(revisao -> {
            lista.addRow(new String[] {
                revisao.getId() + "",
                revisao.getProprietario(),
                revisao.getVeiculo(),
                revisao.getServico(),
                revisao.getData()
            });
        });
        
        lista.addColumn(revisoes);

        controller.desconecta();
        jTable1.setModel(lista);
    }

    public void Selecao() {

        int linha = jTable1.getSelectedRow();  // esta instrução pega o "numero da linha" da grade e coloca na var. "linha"
        // JOptionPane.showMessageDialog(null, "Linha: "+ linha);  // Libere esta instrução e veja o nume da linha da grade

        txtCodigo.setText(jTable1.getValueAt(linha, 0).toString());
        comboProprietario.setSelectedItem(jTable1.getValueAt(linha, 1).toString());
        comboVeiculo.setSelectedItem(jTable1.getValueAt(linha, 2).toString());
        comboServiços.setSelectedItem(jTable1.getValueAt(linha, 3).toString());
        txtData.setText(jTable1.getValueAt(linha, 4).toString());
    }

    public void preencherComboProprietario() throws SQLException {

        controller.conecta();
        String sql = "Select * from veiculos "
                + "ORDER BY proprietario";

        List<String> colunas = controller.getColuna(sql, "proprietario");
        colunas.forEach(coluna -> {
            comboProprietario.addItem(coluna);
        });
        controller.desconecta();
    }

    public void preencherComboVeiculo() throws SQLException {

        controller.conecta();
       
        String sql = "Select * from veiculos";
                
        
        List<String> colunas = controller.getColuna(sql, "modelo");
        colunas.forEach(coluna -> {
            comboVeiculo.addItem(coluna);
        });
        
        controller.desconecta();
    }

    public void preencherComboServiços() throws SQLException {

        controller.conecta();
        String sql = "Select * from servicos"
                + " ORDER BY servico";

        
        List<String> colunas = controller.getColuna(sql, "servico");
        colunas.forEach(coluna -> {
            comboServiços.addItem(coluna);
        });
        controller.desconecta();
    }

    public Cad_Revisao() throws SQLException {
        initComponents();
        
        
        labTitulo.setText("Cadastros");  // Exemplo: Cadastros
        labTela.setText("Revisão");    // Exemplo: Clientes
        labFuncao.setText("");     // ->     Este define nos Botoes
        this.preencherComboProprietario();
        this.preencherComboServiços();
        this.preencherComboVeiculo();
        this.MontaLista();

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
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboProprietario = new javax.swing.JComboBox<>();
        comboVeiculo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();
        comboServiços = new javax.swing.JComboBox<>();
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

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("Veículo");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, -1, -1));

        txtCodigo.setBackground(new java.awt.Color(242, 248, 254));
        txtCodigo.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtCodigo.setForeground(new java.awt.Color(51, 102, 255));
        txtCodigo.setEnabled(false);
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 76, 60, 28));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setText("Código");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 60, -1, -1));

        comboProprietario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboProprietarioMouseClicked(evt);
            }
        });
        comboProprietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProprietarioActionPerformed(evt);
            }
        });
        jPanel1.add(comboProprietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 76, 180, 28));

        comboVeiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboVeiculoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                comboVeiculoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                comboVeiculoMouseReleased(evt);
            }
        });
        comboVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboVeiculoActionPerformed(evt);
            }
        });
        jPanel1.add(comboVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 76, 160, 28));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel6.setText("Proprietário");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setText("Data");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, -1, -1));

        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtData.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtData.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDataFocusLost(evt);
            }
        });
        txtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataActionPerformed(evt);
            }
        });
        jPanel1.add(txtData, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 76, 80, 28));

        jPanel1.add(comboServiços, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 76, 160, 28));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel5.setText("Serviços");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, -1, -1));

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

            controller.executaAtualizacao(" UPDATE revisao SET data = '" + txtData.getText() + "' WHERE cod_revisao = '" + txtCodigo.getText() + "'");

            controller.desconecta();
            MontaLista();
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnDesfazerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesfazerActionPerformed
        comboProprietario.setSelectedItem("");
        comboVeiculo.setSelectedItem("");
        comboServiços.setSelectedItem("");
        txtData.setText("");
        btnAlterar.setEnabled(false);
        btnGravar.setEnabled(false);
        btnDesfazer.setEnabled(false);
    }//GEN-LAST:event_btnDesfazerActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       if (!"".equals(txtCodigo.getText())) {
            controller.conecta();

            controller.executaAtualizacao(" Delete from revisao WHERE cod_revisao = '" + txtCodigo.getText() + "'");

            controller.desconecta();
            MontaLista();
       }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLocalizarActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        if (!"".equals(comboProprietario.getSelectedItem()) && !"".equals(comboVeiculo.getSelectedItem())
                && !"".equals(comboServiços.getSelectedItem()) && !"".equals(txtData.getText())) {

            String proprietario = comboProprietario.getSelectedItem().toString();
            String veiculo = comboVeiculo.getSelectedItem().toString();
            String servico = comboServiços.getSelectedItem().toString();
            String data = txtData.getText();

            controller.conecta();
            controller.executaAtualizacao("INSERT INTO revisao "
                    + "(proprietario, veiculo, servico, data)  VALUES ('"
                    + proprietario + "','"
                    + veiculo + "','"
                    + servico + "','"
                    + data + "')");

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

        comboProprietario.setSelectedItem("");
        comboVeiculo.setSelectedItem("");
        comboServiços.setSelectedItem("");
        txtData.setText("");
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        Selecao();
    }//GEN-LAST:event_jTable1MouseClicked

    private void comboVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboVeiculoActionPerformed
        
        
    }//GEN-LAST:event_comboVeiculoActionPerformed

    private void comboVeiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboVeiculoMouseClicked
          comboVeiculo.removeAllItems();
        try {
            preencherComboVeiculo();
        } catch (SQLException ex) {
            Logger.getLogger(Cad_Revisao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_comboVeiculoMouseClicked

    private void comboProprietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProprietarioActionPerformed

    }//GEN-LAST:event_comboProprietarioActionPerformed

    private void comboVeiculoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboVeiculoMousePressed
         
    }//GEN-LAST:event_comboVeiculoMousePressed

    private void comboVeiculoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboVeiculoMouseReleased
    
    }//GEN-LAST:event_comboVeiculoMouseReleased

    private void comboProprietarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboProprietarioMouseClicked

    }//GEN-LAST:event_comboProprietarioMouseClicked

    private void txtDataFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDataFocusLost
      
    }//GEN-LAST:event_txtDataFocusLost

    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataActionPerformed

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
            java.util.logging.Logger.getLogger(Cad_Revisao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cad_Revisao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cad_Revisao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cad_Revisao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Cad_Revisao().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Cad_Revisao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDesfazer;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnLocalizar;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox<String> comboProprietario;
    private javax.swing.JComboBox<String> comboServiços;
    private javax.swing.JComboBox<String> comboVeiculo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labFuncao;
    private javax.swing.JLabel labTela;
    private javax.swing.JLabel labTitulo;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JFormattedTextField txtData;
    // End of variables declaration//GEN-END:variables
}
