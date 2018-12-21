/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Fornecedor;
import model.MarcaProduto;
import view.CadastroMarca;
import view.jfConsultaMarca;

/**
 *
 * @author bruno
 */
public class MarcaProdutoDAO {

    ConnectionFactory con;
    
    public void inserirMarcaProduto(MarcaProduto marcaProduto){
        con = new ConnectionFactory();
        con.getConnection();
        
        String sql = "INSERT INTO marca_produto (descricao) VALUES (?)";
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setString(1, marcaProduto.getDescricao());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Marca de produtos inserida com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir a marca de produtos!");
            Logger.getLogger(MarcaProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet toComboBox() {
        con = new ConnectionFactory();
        con.getConnection();
        PreparedStatement stmt = null;
        
        try{
            
            // Your database connections  
            ResultSet rs;
            String sql = "select * from marca_produto";
            
            stmt = con.getConnection().prepareStatement(sql);
            
            rs = stmt.executeQuery();
            return rs;
        }
        catch(Exception e){
            System.out.println("Error"+e);
            return null;
        }    
    }
    
          public List<MarcaProduto> listarMarcaProduto(){
        
       con = new ConnectionFactory();
       con.getConnection();
       ResultSet rs = null;
        
        List<MarcaProduto> marcaProdutos = new ArrayList<>();
        
        String sql = "SELECT * FROM marca_produto";                    
        
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {

                MarcaProduto marcaProduto = new MarcaProduto();
                    
                marcaProduto.setIdMarcaProduto(rs.getInt("id_marca"));
                marcaProduto.setDescricao(rs.getString("descricao"));
                marcaProdutos.add(marcaProduto);
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao consultar: " + ex);
        } 
            
        
        return marcaProdutos;
        
    }
     public List<MarcaProduto> listarMarcaProdutoNome(String nomeMarcaProd){
        
       con = new ConnectionFactory();
       con.getConnection();
       ResultSet rs = null;
        
        List<MarcaProduto> marcaProdutos = new ArrayList<>();
        
        String sql = " SELECT * FROM marca_produto WHERE descricao LIKE ? ";
        
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setString(1, "%" + nomeMarcaProd + "%");
            rs = stmt.executeQuery();
            
            while (rs.next()) {

                MarcaProduto marcaProduto = new MarcaProduto();
               
                marcaProduto.setIdMarcaProduto(rs.getInt("id_marca"));
                marcaProduto.setDescricao(rs.getString("descricao"));
                marcaProdutos.add(marcaProduto);
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao consultar: " + ex);
        } 
            
        
        return marcaProdutos;
        
    }
     
     public void alterarMarca(String marca, int idM){
        
        con = new ConnectionFactory();
        con.getConnection();
        
            CadastroMarca cadMar = new CadastroMarca();
        
        String sql = " UPDATE marca_produto set descricao = ? where id_marca= ? ";
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setString(1, marca);
            stmt.setInt(2, idM);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Marca alterada com sucesso!");
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
     
     public void excluirMarca(int linha, int idM){
            
            con = new ConnectionFactory();
            con.getConnection();
            
            jfConsultaMarca jfCons = new jfConsultaMarca();
            linha = jfCons.jtableMarca.getSelectedRow();
            String sql = "DELETE FROM marca_produto WHERE id_marca = ? "; //+ jfCons.jtableCategoria.getSelectedRow();
            
            
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setInt(1, idM);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Marca excluída com sucesso!");
            } catch (SQLException ex) {
            Logger.getLogger(CategoriaProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        }
     
     
     
    public int getLastId(){
        
       con = new ConnectionFactory();
       con.getConnection();
       ResultSet rs = null;
       int id_marca = 0;
  
        
        String sql = "SELECT id_marca FROM marca_produto ORDER BY id_marca DESC LIMIT 1";                    
        
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {

                id_marca = rs.getInt("id_marca");
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao consultar: " + ex);
        } 
            
        
        return id_marca;
        
    }
     
}
