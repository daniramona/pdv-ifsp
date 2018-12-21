/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ProdutoDAO;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Produto;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class PDV extends javax.swing.JFrame {

    /**
     * Creates new form PDV
     */
    public PDV() {
        initComponents();
        
    // Bloqueia o Resize: //
        this.setResizable(false); 
        
    /* Maximiza a janela ao iniciar: //
         this.setExtendedState(jfTelaPrincipal.MAXIMIZED_BOTH); */
                
      Color backgroundColor = new Color(206, 222, 255);
        // Alterar a cor do formulário: //
       this.getContentPane().setBackground(backgroundColor);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipoVenda = new javax.swing.ButtonGroup();
        jfConsultaCategoria1 = new view.jfConsultaCategoria();
        jlPDV = new javax.swing.JLabel();
        jlTipo = new javax.swing.JLabel();
        vendaFiscal = new javax.swing.JRadioButton();
        vendaSimples = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        dataVenda = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jbPgto = new javax.swing.JButton();
        jbAddProduto1 = new javax.swing.JButton();
        jbDelProduto1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProduto = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        nroNF = new javax.swing.JTextField();
        jbCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jtValorTotal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PONTO DE VENDA - PDV");

        jlPDV.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jlPDV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/shopping-cart.png"))); // NOI18N
        jlPDV.setText("Ponto de Venda");

        jlTipo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlTipo.setText("Tipo:");

        tipoVenda.add(vendaFiscal);
        vendaFiscal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        vendaFiscal.setText("Fiscal /");

        tipoVenda.add(vendaSimples);
        vendaSimples.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        vendaSimples.setText("Simples");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Data:");

        try {
            dataVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dataVenda.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Cliente:");

        jPanel1.setBackground(new java.awt.Color(206, 222, 255));

        jbPgto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbPgto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/coins.png"))); // NOI18N
        jbPgto.setText("PAGAR");
        jbPgto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPgtoActionPerformed(evt);
            }
        });

        jbAddProduto1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbAddProduto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus-black-symbol.png"))); // NOI18N
        jbAddProduto1.setText("ADICIONAR");
        jbAddProduto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddProduto1ActionPerformed(evt);
            }
        });

        jbDelProduto1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbDelProduto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/erase.png"))); // NOI18N
        jbDelProduto1.setText("EXCLUIR");
        jbDelProduto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDelProduto1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbAddProduto1)
                .addGap(18, 18, 18)
                .addComponent(jbDelProduto1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbPgto, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAddProduto1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbDelProduto1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbPgto, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTableProduto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTableProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO PRODUTO", "PRODUTO", "QUANTIDADE", "VALOR UN"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProduto.setGridColor(new java.awt.Color(193, 167, 207));
        jTableProduto.setRowHeight(25);
        jTableProduto.setSelectionBackground(new java.awt.Color(183, 225, 227));
        jTableProduto.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jTableProduto);
        if (jTableProduto.getColumnModel().getColumnCount() > 0) {
            jTableProduto.getColumnModel().getColumn(0).setResizable(false);
            jTableProduto.getColumnModel().getColumn(1).setResizable(false);
            jTableProduto.getColumnModel().getColumn(2).setResizable(false);
            jTableProduto.getColumnModel().getColumn(3).setResizable(false);
        }

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Nota Fiscal:");

        nroNF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jbCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sign-out-option.png"))); // NOI18N
        jbCancelar.setText("Cancelar Venda");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("VALOR TOTAL:");

        jtValorTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtValorTotal.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlTipo)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(vendaFiscal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(vendaSimples)))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(dataVenda))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nroNF, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(11, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 985, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbCancelar)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(349, 349, 349)
                .addComponent(jlPDV)
                .addGap(0, 381, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlPDV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTipo)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vendaFiscal)
                    .addComponent(vendaSimples)
                    .addComponent(dataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nroNF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbCancelar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(61, 61, 61))
        );

        setSize(new java.awt.Dimension(1022, 628));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbPgtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPgtoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbPgtoActionPerformed

    private void jbAddProduto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddProduto1ActionPerformed
        jfLancaProduto telaProduto;
        telaProduto = new jfLancaProduto(this);
        telaProduto.setVisible(true);

    }//GEN-LAST:event_jbAddProduto1ActionPerformed

    private void jbDelProduto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDelProduto1ActionPerformed
        
       Object[] options = { "Sim", "Não" };        
        
        if(jTableProduto.getSelectedRow() == -1){
            
            JOptionPane.showMessageDialog(null, "Selecione um registro!");
            
        } else {
        int i = JOptionPane.showOptionDialog(null,
				"Deseja realmente excluir o item? ", "AVISO:",
				JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null,
				options, options[0]);  
        
		if (i == JOptionPane.YES_OPTION) {
                    
                    ((DefaultTableModel) jTableProduto.getModel()).removeRow(jTableProduto.getSelectedRow());
                            float valor_total = 0;
                            int nRow = jTableProduto.getRowCount();
        
                         for (i = 0 ; i < nRow ; i++){
                         int quantidade = Integer.parseInt(jTableProduto.getValueAt(i,2).toString());
                         float valor = Float.parseFloat(jTableProduto.getValueAt(i, 3).toString());
            
                         float total_produto = valor * quantidade;
                         valor_total += total_produto;
          
            
        }
                
        jtValorTotal.setText(String.valueOf(String.format("%.02f",valor_total)));
        
    }          
    }
    }//GEN-LAST:event_jbDelProduto1ActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
             // TODO add your handling code here:
        
        // Exibe mensagem de confirmação de cancelamento //
  Object[] options = { "Sim", "Não" };
		int i = JOptionPane.showOptionDialog(null,
				"Deseja realmente cancelar a venda? Você perderá todos os dados!", "AVISO:",
				JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null,
				options, options[0]);
		if (i == JOptionPane.YES_OPTION) {
			this.dispose();
		}
    }//GEN-LAST:event_jbCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(PDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PDV().setVisible(true);
            }
        });
    }
    
    public void lancarProduto(Produto p){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = (DefaultTableModel) jTableProduto.getModel();
               
        modelo.addRow(new Object[]{
            p.getIdProduto(),
            p.getDiscriminacao(),
            p.getQuantidade(),
            p.getValorUnitario()
        });
        
        float valor_total = 0;
        int nRow = modelo.getRowCount();
        
        for (int i = 0 ; i < nRow ; i++){
            int quantidade = Integer.parseInt(modelo.getValueAt(i,2).toString());
            float valor = Float.parseFloat(modelo.getValueAt(i, 3).toString());
            
            float total_produto = valor * quantidade;
            valor_total += total_produto;
          
            
        }
                
        jtValorTotal.setText(String.valueOf(String.format("%.02f",valor_total)));
       
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField dataVenda;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProduto;
    private javax.swing.JButton jbAddProduto1;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbDelProduto1;
    private javax.swing.JButton jbPgto;
    private view.jfConsultaCategoria jfConsultaCategoria1;
    private javax.swing.JLabel jlPDV;
    private javax.swing.JLabel jlTipo;
    private javax.swing.JTextField jtValorTotal;
    private javax.swing.JTextField nroNF;
    private javax.swing.ButtonGroup tipoVenda;
    private javax.swing.JRadioButton vendaFiscal;
    private javax.swing.JRadioButton vendaSimples;
    // End of variables declaration//GEN-END:variables
}