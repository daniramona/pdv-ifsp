/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ClienteDAO;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Cliente;
import model.EnderecoCliente;
import model.EnderecoPessoa;
import model.Pessoa;

/**
 *
 * @author Pereira
 */
public class jfConsultaCliente extends javax.swing.JFrame {
    
    public jfConsultaCliente() {
        initComponents();
        
        Color backgroundColor = new Color(206, 222, 255);
              
        // Alterar a cor do formulário: //
       this.getContentPane().setBackground(backgroundColor);
       // jtableCliente.setModel(tableModel);
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = (DefaultTableModel) jtableCliente.getModel();
        jtableCliente.setRowSorter(new TableRowSorter(modelo));
        
        listarJTable();  
    }
    
    public void listarJTable(){
        
            DefaultTableModel modelo = new DefaultTableModel();
            modelo = (DefaultTableModel) jtableCliente.getModel();
            modelo.setNumRows(0);
            
            ClienteDAO clientDAO = new ClienteDAO();
            
            for(Cliente cli: clientDAO.listarCliente()){
                
                
                modelo.addRow(new Object[]{
                

                    cli.getIdCliente(),
                    cli.getNome(),
                    cli.getTipoPessoa(),  
                    cli.getEmail(),
                    cli.getRgIe(),
                    cli.getCpfCnpj(),                    
                    cli.getTelefone(),
                    cli.getTelefone2()

                });
            }   
        
    }
        public void listarJTableNome(String nomeCli){
        
            DefaultTableModel modelo = new DefaultTableModel();
            modelo = (DefaultTableModel) jtableCliente.getModel();
            modelo.setNumRows(0);
            
            ClienteDAO clientDAO = new ClienteDAO();
            
            for(Cliente cli: clientDAO.listarCliente(nomeCli)){
                
                modelo.addRow(new Object[]{
                
                cli.getIdCliente(),
                    cli.getNome(),
                    cli.getTipoPessoa(),  
                    cli.getEmail(),
                    cli.getRgIe(),
                    cli.getCpfCnpj(),                    
                    cli.getTelefone(),
                    cli.getTelefone2()
      
                        
            });
            }   
        
    }
      

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableCliente = new javax.swing.JTable();
        jtBusca = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        jbNovo = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbAtualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Clientes");

        jbExcluir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/erase.png"))); // NOI18N
        jbExcluir.setText("Excluir");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jtableCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtableCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Tipo", "Email", "RG/IE", "CPF/CNPJ", "Telefone", "Telefone 2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtableCliente.setSelectionBackground(new java.awt.Color(102, 153, 255));
        jtableCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtableCliente);
        if (jtableCliente.getColumnModel().getColumnCount() > 0) {
            jtableCliente.getColumnModel().getColumn(0).setResizable(false);
            jtableCliente.getColumnModel().getColumn(1).setResizable(false);
            jtableCliente.getColumnModel().getColumn(2).setResizable(false);
            jtableCliente.getColumnModel().getColumn(3).setResizable(false);
            jtableCliente.getColumnModel().getColumn(4).setResizable(false);
            jtableCliente.getColumnModel().getColumn(5).setResizable(false);
            jtableCliente.getColumnModel().getColumn(7).setResizable(false);
        }

        jbBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbNovo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus-black-symbol.png"))); // NOI18N
        jbNovo.setText("Novo");
        jbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoActionPerformed(evt);
            }
        });

        jbEditar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        jbEditar.setText("Editar");
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jbAtualizar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh-page-option.png"))); // NOI18N
        jbAtualizar.setText("Atualizar");
        jbAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbBuscar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbNovo)
                        .addGap(18, 18, 18)
                        .addComponent(jbEditar)
                        .addGap(18, 18, 18)
                        .addComponent(jbAtualizar)
                        .addGap(28, 28, 28))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbExcluir)
                    .addComponent(jbNovo)
                    .addComponent(jbEditar)
                    .addComponent(jbAtualizar))
                .addGap(20, 20, 20))
        );

        setSize(new java.awt.Dimension(757, 500));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        listarJTableNome(jtBusca.getText());
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed
        CadastroCliente tela;
        try {
            tela = new CadastroCliente();
            tela.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(jfConsultaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jbNovoActionPerformed

    private void jbAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAtualizarActionPerformed
       listarJTable();
    }//GEN-LAST:event_jbAtualizarActionPerformed
   
    private void jtableClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableClienteMouseClicked
        
        if(evt.getClickCount() == 2){
        
            CadastroCliente cadcli;    
            try {
                cadcli = new CadastroCliente();
                cadcli.setVisible(true);
        
                int indiceLinha = jtableCliente.getSelectedRow();
                int idCliente = Integer.parseInt(jtableCliente.getValueAt(indiceLinha, 0).toString());

                ClienteDAO clienteDao = new ClienteDAO();
                List<Object> list = new ArrayList<>(clienteDao.populateCliente(idCliente));
                Pessoa p = (Pessoa) list.get(0);
                Cliente c = (Cliente) list.get(1);
                EnderecoPessoa endpes = (EnderecoPessoa) list.get(2);
                EnderecoCliente endcli = (EnderecoCliente) list.get(3);

                cadcli.jtCodCliente.setText(String.valueOf(c.getIdCliente()));
                cadcli.jtNome.setText(p.getNome());
                cadcli.tipo_cliente.setSelectedItem(c.getTipoPessoa());
                cadcli.jtEmail.setText(p.getEmail());
                String d = c.getDataNascimento().split("-")[2] + "/" + c.getDataNascimento().split("-")[1] + "/" + c.getDataNascimento().split("-")[0];
                cadcli.jtDataNasc.setText(d);
                cadcli.jtCpfCnpj.setText(p.getCpfCnpj());
                cadcli.jtRgIe.setText(p.getRgIe());
                cadcli.jtTel.setText(endcli.getTelefone());
                cadcli.jtCel.setText(endcli.getTelefone2());
                cadcli.jtRua.setText(endpes.getRua());
                cadcli.jtNro.setText(String.valueOf(endpes.getIdEndereco()));
                cadcli.jtCep.setText(endpes.getCep());
                cadcli.jtBairro.setText(endpes.getBairro());
                //cadcli.jtUF.setSelectedItem(endpes.getEstado());
                cadcli.jtRuaCliente.setText(endcli.getRua());
                cadcli.jtBairroCliente.setText(endcli.getBairro());
                
                
                
                


                System.out.println(p.getNome());

            } catch (SQLException ex) {
                Logger.getLogger(jfConsultaCliente.class.getName()).log(Level.SEVERE, null, ex);
            }       
        }
    }//GEN-LAST:event_jtableClienteMouseClicked

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
       
        Object[] options = { "Sim", "Não" };        

        if(jtableCliente.getSelectedRow() == -1){   
            JOptionPane.showMessageDialog(null, "Selecione um registro!");      
        } 
        else {
            int i = JOptionPane.showOptionDialog(null,
                     "Deseja realmente excluir o registro? Você perderá todos os dados!", "AVISO:",
                     JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null,
                     options, options[0]);  

            if (i == JOptionPane.YES_OPTION) {
                int indiceLinha = jtableCliente.getSelectedRow();
                int idCliente = Integer.parseInt(jtableCliente.getValueAt(indiceLinha, 0).toString());

                ClienteDAO clienteDao = new ClienteDAO();
                clienteDao.ExcluirCliente(idCliente);
            } 
        }
            
    }//GEN-LAST:event_jbExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(jfConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfConsultaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAtualizar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbNovo;
    private javax.swing.JTextField jtBusca;
    private javax.swing.JTable jtableCliente;
    // End of variables declaration//GEN-END:variables
}
