/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaagenciaviagens.view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistemaagenciaviagens.controller.FuncionarioController;

/**
 *
 * @author Caio
 */
public class FuncionarioView extends javax.swing.JFrame {

    private FuncionarioController controlador;
    
    public FuncionarioView() {
        this.controlador = new FuncionarioController();
        initComponents();
        dadosPanel.setVisible(false);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        menuPanel = new javax.swing.JPanel();
        cadastrarButton = new javax.swing.JButton();
        alterarButton = new javax.swing.JButton();
        listarButton = new javax.swing.JButton();
        excluirButton = new javax.swing.JButton();
        sairButton = new javax.swing.JButton();
        dadosPanel = new javax.swing.JPanel();
        nomeLabel = new javax.swing.JLabel();
        telefoneLabel = new javax.swing.JLabel();
        cepLabel = new javax.swing.JLabel();
        estadoLabel = new javax.swing.JLabel();
        cidadeLabel = new javax.swing.JLabel();
        bairroLabel = new javax.swing.JLabel();
        ruaLabel = new javax.swing.JLabel();
        numeroLabel = new javax.swing.JLabel();
        admissaoLabel = new javax.swing.JLabel();
        demissaoLabel = new javax.swing.JLabel();
        nomeField = new javax.swing.JTextField();
        telefoneField = new javax.swing.JTextField();
        cepField = new javax.swing.JTextField();
        estadoField = new javax.swing.JTextField();
        cidadeField = new javax.swing.JTextField();
        bairroField = new javax.swing.JTextField();
        ruaField = new javax.swing.JTextField();
        numeroField = new javax.swing.JTextField();
        admissaoField = new javax.swing.JTextField();
        demissaoField = new javax.swing.JTextField();
        salvarButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        codigoLabel = new javax.swing.JLabel();
        codigoField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        dadosTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Funcionarios");

        menuPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        cadastrarButton.setText("Cadastrar novo Funcion??rio");
        cadastrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarButtonActionPerformed(evt);
            }
        });

        alterarButton.setText("Alterar Funcion??rio");
        alterarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarButtonActionPerformed(evt);
            }
        });

        listarButton.setText("Listar Todos os Funcion??rios");
        listarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarButtonActionPerformed(evt);
            }
        });

        excluirButton.setText("Excluir Funcion??rio");
        excluirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirButtonActionPerformed(evt);
            }
        });

        sairButton.setText("Sair");
        sairButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cadastrarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(alterarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listarButton, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                    .addComponent(excluirButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sairButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cadastrarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alterarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(excluirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sairButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        dadosPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        nomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nomeLabel.setText("*Nome: ");

        telefoneLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        telefoneLabel.setText("*Telefone: ");

        cepLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cepLabel.setText("*CEP: ");

        estadoLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        estadoLabel.setText("*Estado: ");

        cidadeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cidadeLabel.setText("*Cidade: ");

        bairroLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        bairroLabel.setText("*Bairro: ");

        ruaLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ruaLabel.setText("*Rua: ");

        numeroLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        numeroLabel.setText("*Numero: ");

        admissaoLabel.setText("*Data de Admiss??o: ");

        demissaoLabel.setText("Data de Demiss??o: ");

        salvarButton.setText("Salvar");
        salvarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarButtonActionPerformed(evt);
            }
        });

        cancelarButton.setText("Cancelar");
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });

        codigoLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        codigoLabel.setText("C??digo: ");

        codigoField.setEnabled(false);

        javax.swing.GroupLayout dadosPanelLayout = new javax.swing.GroupLayout(dadosPanel);
        dadosPanel.setLayout(dadosPanelLayout);
        dadosPanelLayout.setHorizontalGroup(
            dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dadosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dadosPanelLayout.createSequentialGroup()
                        .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(numeroLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ruaLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bairroLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cidadeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(estadoLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cepLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nomeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(telefoneLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(codigoLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomeField)
                            .addComponent(telefoneField)
                            .addComponent(cepField)
                            .addComponent(estadoField)
                            .addComponent(cidadeField)
                            .addComponent(bairroField)
                            .addComponent(ruaField)
                            .addComponent(numeroField)
                            .addComponent(codigoField)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dadosPanelLayout.createSequentialGroup()
                        .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(admissaoLabel)
                            .addComponent(demissaoLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dadosPanelLayout.createSequentialGroup()
                                .addComponent(cancelarButton, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(salvarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(admissaoField)
                            .addComponent(demissaoField))))
                .addContainerGap())
        );
        dadosPanelLayout.setVerticalGroup(
            dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefoneLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cepField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cepLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(estadoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estadoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cidadeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cidadeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bairroField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bairroLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ruaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ruaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeroField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numeroLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(admissaoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(admissaoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(demissaoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(demissaoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelarButton, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(salvarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        dadosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "C??digo", "Nome", "Telefone", "CEP", "Estado", "Cidade", "Bairro", "Rua", "Numero", "Data de Admiss??o", "Data de Demiss??o"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(dadosTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(dadosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dadosPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarButtonActionPerformed
        
        dadosPanel.setVisible(true);
        limparDados();
        codigoField.setText("0");
        
    }//GEN-LAST:event_cadastrarButtonActionPerformed

    private void salvarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarButtonActionPerformed
        
        int codigo = Integer.parseInt(codigoField.getText());
        // Pessoa
        String nome = nomeField.getText();
        String telefone = telefoneField.getText();
        String cep = cepField.getText();
        String estado = estadoField.getText();
        String cidade = cidadeField.getText();
        String bairro = bairroField.getText();
        String rua = ruaField.getText();
        String numero = numeroField.getText();
        // Funcionario
        String dataAdmissao = admissaoField.getText();
        String dataDemissao = demissaoField.getText();
        
        if(dataDemissao.equals("")){
            dataDemissao = "11/11/9999";
        }
        
        if(!((nome.equals("")) || (telefone.equals("")) || (cep.equals("")) ||
          (estado.equals("")) || (cidade.equals("")) || (bairro.equals("")) || 
          (rua.equals("")) || (numero.equals("")) || (dataAdmissao.equals(""))))
        {
            try {
                this.controlador.salvar(codigo, nome, telefone, cep, estado, cidade, bairro,
                rua, numero, dataAdmissao, dataDemissao);
                JOptionPane.showMessageDialog(rootPane, "Funcion??rio Salvo com sucesso!");
                dadosPanel.setVisible(false);
                limparDados();
                atualizarTabela();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Campos com '*' s??o obrigat??rios!");
        }
        
    }//GEN-LAST:event_salvarButtonActionPerformed

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
       
        dadosPanel.setVisible(false);
        limparDados();
        
    }//GEN-LAST:event_cancelarButtonActionPerformed

    private void sairButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairButtonActionPerformed
        
        this.dispose();
        
    }//GEN-LAST:event_sairButtonActionPerformed

    private void listarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarButtonActionPerformed
        atualizarTabela();
    }//GEN-LAST:event_listarButtonActionPerformed

    private void alterarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarButtonActionPerformed
        
        DefaultTableModel modelo = (DefaultTableModel)dadosTable.getModel();
        int selectedRow = dadosTable.getSelectedRow();
        
        if(selectedRow > -1)
        {
            limparDados();
            
            codigoField.setText(modelo.getValueAt(selectedRow, 0).toString());
            nomeField.setText(modelo.getValueAt(selectedRow, 1).toString());
            telefoneField.setText(modelo.getValueAt(selectedRow, 2).toString());
            cepField.setText(modelo.getValueAt(selectedRow, 3).toString());
            estadoField.setText(modelo.getValueAt(selectedRow, 4).toString());
            cidadeField.setText(modelo.getValueAt(selectedRow, 5).toString());
            bairroField.setText(modelo.getValueAt(selectedRow, 6).toString());
            ruaField.setText(modelo.getValueAt(selectedRow, 7).toString());
            numeroField.setText(modelo.getValueAt(selectedRow, 8).toString());
            admissaoField.setText(modelo.getValueAt(selectedRow, 9).toString());
            demissaoField.setText(
                    modelo.getValueAt(selectedRow, 10).toString() == "funcion??rio ativo" ?
                            "" : modelo.getValueAt(selectedRow, 10).toString()
            );            
            
            dadosPanel.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Selecione um funcion??rio para alterar!");
        }
        
        
    }//GEN-LAST:event_alterarButtonActionPerformed

    private void excluirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirButtonActionPerformed
        
        DefaultTableModel modelo = (DefaultTableModel)dadosTable.getModel();
        int selectedRow = dadosTable.getSelectedRow();
        
        if(selectedRow > -1)
        {
            try {
                this.controlador.excluir(Integer.parseInt(modelo.getValueAt(selectedRow, 0).toString()));
                JOptionPane.showMessageDialog(rootPane, "Funcionario excluido com sucesso!");
                atualizarTabela();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e.getMessage());
            }
        }
        else
        {   
            JOptionPane.showMessageDialog(rootPane, "Selecione um funcion??rio para excluir!");
        }
        
    }//GEN-LAST:event_excluirButtonActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(FuncionarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FuncionarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FuncionarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FuncionarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FuncionarioView().setVisible(true);
            }
        });
    }

    private void limparDados(){
        nomeField.setText("");
        telefoneField.setText("");
        cepField.setText("");
        estadoField.setText("");
        cidadeField.setText("");
        bairroField.setText("");
        ruaField.setText("");
        numeroField.setText("");
        // Funcionario
        admissaoField.setText("");
        demissaoField.setText("");
    }
    
    private void atualizarTabela(){
        ((DefaultTableModel) dadosTable.getModel()).setRowCount(0);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        this.controlador.buscarTodos();
        
        for(int i=0; i<this.controlador.getListaDeFuncionarios().size(); i++){
            
            ((DefaultTableModel) dadosTable.getModel()).addRow(new Object[]{
                this.controlador.getListaDeFuncionarios().get(i).getCodigo(),
                this.controlador.getListaDeFuncionarios().get(i).getNome(),
                this.controlador.getListaDeFuncionarios().get(i).getTelefone(),
                this.controlador.getListaDeFuncionarios().get(i).getCep(),
                this.controlador.getListaDeFuncionarios().get(i).getEstado(),
                this.controlador.getListaDeFuncionarios().get(i).getCidade(),
                this.controlador.getListaDeFuncionarios().get(i).getBairro(),
                this.controlador.getListaDeFuncionarios().get(i).getRua(),
                this.controlador.getListaDeFuncionarios().get(i).getNumero(),
                sdf.format(this.controlador.getListaDeFuncionarios().get(i).getDataAdmissao().getTime()),
                !(sdf.format(this.controlador.getListaDeFuncionarios().get(i).getDataDemissao().getTime()).equals("11/11/9999")) ? 
                        sdf.format(this.controlador.getListaDeFuncionarios().get(i).getDataDemissao().getTime()) : "funcion??rio ativo"
            });
            
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField admissaoField;
    private javax.swing.JLabel admissaoLabel;
    private javax.swing.JButton alterarButton;
    private javax.swing.JTextField bairroField;
    private javax.swing.JLabel bairroLabel;
    private javax.swing.JButton cadastrarButton;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JTextField cepField;
    private javax.swing.JLabel cepLabel;
    private javax.swing.JTextField cidadeField;
    private javax.swing.JLabel cidadeLabel;
    private javax.swing.JTextField codigoField;
    private javax.swing.JLabel codigoLabel;
    private javax.swing.JPanel dadosPanel;
    private javax.swing.JTable dadosTable;
    private javax.swing.JTextField demissaoField;
    private javax.swing.JLabel demissaoLabel;
    private javax.swing.JTextField estadoField;
    private javax.swing.JLabel estadoLabel;
    private javax.swing.JButton excluirButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton listarButton;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JTextField nomeField;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JTextField numeroField;
    private javax.swing.JLabel numeroLabel;
    private javax.swing.JTextField ruaField;
    private javax.swing.JLabel ruaLabel;
    private javax.swing.JButton sairButton;
    private javax.swing.JButton salvarButton;
    private javax.swing.JTextField telefoneField;
    private javax.swing.JLabel telefoneLabel;
    // End of variables declaration//GEN-END:variables
}
