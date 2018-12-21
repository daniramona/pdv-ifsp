package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Venda;

/**
 *
 * @author bruno
 */
public class vendaDAO {
     ConnectionFactory con;
    
    public void inserirVenda(Venda venda){
        con = new ConnectionFactory();
        con.getConnection();
        
        String sql = "INSERT INTO venda (data_venda, tipo_venda, nota_fiscal) values (?, ?, ?)";
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setString(1, venda.getDataVenda());
            stmt.setString(2, venda.getTipoVenda());
            stmt.setString(3, venda.getNotaFiscal());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Venda inserida com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir a venda!");
        }
    }
}
