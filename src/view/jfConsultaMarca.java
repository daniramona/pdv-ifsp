/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MarcaProdutoDAO;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.MarcaProduto;

/**
 *
 * @author Pereira
 */
public class jfConsultaMarca extends javax.swing.JFrame {

    /**
     * Creates new form jfConsultaMarca
     */
    public jfConsultaMarca() {
        
        initComponents();
        
        Color backgroundColor = new Color(206, 222, 255);
        // Alterar a cor do formulário: //
       this.getContentPane().setBackground(backgroundColor);
       
       
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = (DefaultTableModel) jtableMarca.getModel();
        jtableMarca.setRowSorter(new TableRowSorter(modelo));
        
        listarJTable();
    }
    
    public void listarJTable(){
        
            DefaultTableModel modelo = new DefaultTableModel();
            modelo = (DefaultTableModel) jtableMarca.getModel();
            modelo.setNumRows(0);
            
            MarcaProdutoDAO marcaProduto = new MarcaProdutoDAO();
            
            for(MarcaProduto marcaProd: marcaProduto.listarMarcaProduto()){
                
                modelo.addRow(new Object[]{
                
                marcaProd.getIdMarcaProduto(),
                marcaProd.getDescricao()                   
                        
            });
            }   
        
    }
     public void listarJTableNome(String nomeMarcaProd){
        
            DefaultTableModel modelo = new DefaultTableModel();
            modelo = (DefaultTableModel) jtableMarca.getModel();
            modelo.setNumRows(0);
            
            MarcaProdutoDAO marcaProduto = new MarcaProdutoDAO();
            
            for(MarcaProduto marcaProd: marcaProduto.listarMarcaProdutoNome(nomeMarcaProd)){
                
                modelo.addRow(new Object[]{
                
                marcaProd.getIdMarcaProduto(),
                marcaProd.getDescricao()
                        
            });
            }   
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbExcluir = new javax.swing.JButton();
        jbNovo = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbAtualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableMarca = new javax.swing.JTable();
        jtBusca = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Marcas");

        jbExcluir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/erase.png"))); // NOI18N
        jbExcluir.setText("Excluir");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
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

        jtableMarca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtableMarca.setSelectionBackground(new java.awt.Color(102, 153, 255));
        jtableMarca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableMarcaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtableMarca);
        if (jtableMarca.getColumnModel().getColumnCount() > 0) {
            jtableMarca.getColumnModel().getColumn(1).setResizable(false);
        }

        jbBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
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
                .addContainerGap(24, Short.MAX_VALUE)
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

        setSize(new java.awt.Dimension(783, 506));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed
        CadastroMarca tela = new CadastroMarca();
        tela.setVisible(true);
    }//GEN-LAST:event_jbNovoActionPerformed

    private void jbAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAtualizarActionPerformed
        listarJTable();
    }//GEN-LAST:event_jbAtualizarActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        listarJTableNome(jtBusca.getText());
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
            CadastroMarca cadMar = new CadastroMarca();
            cadMar.setVisible(true);
            cadMar.op = "editar";
            int indiceLinha = jtableMarca.getSelectedRow();
            cadMar.jtCodMarca.setEnabled(false);
            cadMar.jtCodMarca.setText(jtableMarca.getValueAt(indiceLinha, 0).toString());
            cadMar.jtMarca.setText(jtableMarca.getValueAt(indiceLinha, 1).toString());
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jtableMarcaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableMarcaMouseClicked
        
        if(evt.getClickCount() == 2){
            CadastroMarca cadMar = new CadastroMarca();
            cadMar.setVisible(true);
            cadMar.op = "editar";
            int indiceLinha = jtableMarca.getSelectedRow();
            cadMar.jtCodMarca.setEnabled(false);
            cadMar.jtCodMarca.setText(jtableMarca.getValueAt(indiceLinha, 0).toString());
            cadMar.jtMarca.setText(jtableMarca.getValueAt(indiceLinha, 1).toString());

            
            
            
        }
    }//GEN-LAST:event_jtableMarcaMouseClicked

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
         Object[] options = { "Sim", "Não" };        
        
        if(jtableMarca.getSelectedRow() == -1){
            
            JOptionPane.showMessageDialog(null, "Selecione um registro!");
            
        } else {
        int i = JOptionPane.showOptionDialog(null,
				"Deseja realmente excluir o registro? Você perderá todos os dados!", "AVISO:",
				JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null,
				options, options[0]);  
        
		if (i == JOptionPane.YES_OPTION) {
                    
                        MarcaProdutoDAO marDao = new MarcaProdutoDAO();
        
                        int linha = jtableMarca.getSelectedRow();
                        int idM = (int) jtableMarca.getValueAt(linha, 0);
                        marDao.excluirMarca(linha, idM);
			
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
            java.util.logging.Logger.getLogger(jfConsultaMarca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfConsultaMarca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfConsultaMarca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfConsultaMarca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfConsultaMarca().setVisible(true);
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
    public javax.swing.JTextField jtBusca;
    public javax.swing.JTable jtableMarca;
    // End of variables declaration//GEN-END:variables
}