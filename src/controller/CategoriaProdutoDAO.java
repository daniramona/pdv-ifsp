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
import model.CategoriaProduto;
import model.Produto;
import view.CadastroCategoria;
import view.jfConsultaCategoria;

/**
 *
 * @author bruno
 */
public class CategoriaProdutoDAO {
    ConnectionFactory con;
    
    public void inserirCategoriaProduto(CategoriaProduto categoriaProduto){
        con = new ConnectionFactory();
        con.getConnection();
        
        String sql = "INSERT INTO categoria_produto (descricao) VALUES (?)";
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setString(1, categoriaProduto.getDescricao());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Categoria de produtos inserida com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir a categoria de produtos!");
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
            String sql = "select * from categoria_produto";
            
            stmt = con.getConnection().prepareStatement(sql);
            
            rs = stmt.executeQuery();
            return rs;
        }
        catch(Exception e){
            System.out.println("Error"+e);
            return null;
        }    
    } 
    
       public List<CategoriaProduto> listarCategoria(){
        
       con = new ConnectionFactory();
       con.getConnection();
       ResultSet rs = null;
        
        List<CategoriaProduto> categoriaProdutos = new ArrayList<>();
        
        String sql = "SELECT * FROM categoria_produto";
        
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {

                CategoriaProduto categoriaProduto = new CategoriaProduto();
                
                categoriaProduto.setIdCategoria(rs.getInt("id_categoria"));
                categoriaProduto.setDescricao(rs.getString("descricao"));
                categoriaProdutos.add(categoriaProduto);             
             
          
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao consultar: " + ex);
        } 
            
        
        return categoriaProdutos;
        
    }
       public List<CategoriaProduto> listarCategoria(String descricao){
        
       con = new ConnectionFactory();
       con.getConnection();
       ResultSet rs = null;
        
        List<CategoriaProduto> categoriaProdutos = new ArrayList<>();
        
        String sql = " SELECT * FROM categoria_produto WHERE descricao LIKE ? ";
        
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setString(1, "%" + descricao + "%");
            rs = stmt.executeQuery();
            
            while (rs.next()) {

                CategoriaProduto categoriaProduto = new CategoriaProduto();
                
                categoriaProduto.setIdCategoria(rs.getInt("id_categoria"));
                categoriaProduto.setDescricao(rs.getString("descricao"));
                categoriaProdutos.add(categoriaProduto);             
             
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao consultar: " + ex);
        } 
            
        
        return categoriaProdutos;
        
    }
       
        public void alterarCategoria(String categoria, int idC){
        
        con = new ConnectionFactory();
        con.getConnection();
        
            CadastroCategoria cadCat = new CadastroCategoria();
        
        String sql = " UPDATE categoria_produto set descricao = ? where id_categoria = ? ";
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setString(1, categoria);
            stmt.setInt(2, idC);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Categoria alterada com sucesso!");
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
        
         public void excluirCategoria(int linha, int idC){
            
            con = new ConnectionFactory();
            con.getConnection();
            
            jfConsultaCategoria jfCons = new jfConsultaCategoria();
            linha = jfCons.jtableCategoria.getSelectedRow();
            String sql = "DELETE FROM categoria_produto WHERE id_categoria = ? "; //+ jfCons.jtableCategoria.getSelectedRow();
            
            
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setInt(1, idC);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Categoria excluída com sucesso!");
            } catch (SQLException ex) {
            Logger.getLogger(CategoriaProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        }
         
         
         // EXIBI CÓDIGO DO CADASTRO PARA O USUÁRIO NA TELA DE CADASTRO //
         
         public int getLastId(){
        
       con = new ConnectionFactory();
       con.getConnection();
       ResultSet rs = null;
       int id_categoria = 0;
  
        
        String sql = "SELECT id_categoria FROM categoria_produto ORDER BY id_categoria DESC LIMIT 1";                    
        
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {

                id_categoria = rs.getInt("id_categoria");
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao consultar: " + ex);
        } 
            
        
        return id_categoria;
        
    }
         
              
}
