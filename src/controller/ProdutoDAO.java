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
import model.Produto;

/**
 *
 * @author bruno
 */
public class ProdutoDAO {
    
    ConnectionFactory con;
    
    public void inserirProduto(Produto produto){
        con = new ConnectionFactory();
        con.getConnection();
        
        String sql = "INSERT INTO produto (cod_ean, discriminacao, valor_custo, margem_lucro, cod_marca, cod_categoria) values (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setString(1, produto.getCodEan());
            stmt.setString(2, produto.getDiscriminacao());
            stmt.setFloat(3, produto.getValorCusto());
            stmt.setFloat(4, produto.getMargemLucro());
            stmt.setInt(5, produto.getCodMarca());
            stmt.setInt(6, produto.getCodCategoria());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto inserido com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir o produto!");
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void alterarProduto(Produto produto){
        con = new ConnectionFactory();
        con.getConnection();
        
        System.out.println(produto.getIdProduto());
        
        String sql = "UPDATE produto SET cod_ean = ?, discriminacao = ?, valor_custo = ?, margem_lucro = ?, cod_marca = ?, cod_categoria = ? WHERE id_produto = ?";
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setString(1, produto.getCodEan());
            stmt.setString(2, produto.getDiscriminacao());
            stmt.setFloat(3, produto.getValorCusto());
            stmt.setFloat(4, produto.getMargemLucro());
            stmt.setInt(5, produto.getCodMarca());
            stmt.setInt(6, produto.getCodCategoria());
            stmt.setInt(7, produto.getIdProduto());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar o produto!");
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
        
    
     public List<Produto> listarProduto(){
        
       con = new ConnectionFactory();
       con.getConnection();
       ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        
        String sql = "SELECT * FROM produto ";
        
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {

                Produto produto = new Produto();
                
                produto.setIdProduto(rs.getInt("id_produto"));
                produto.setCodEan(rs.getString("cod_ean"));
                produto.setDiscriminacao(rs.getString("discriminacao"));
                produto.setValorCusto(rs.getFloat("valor_custo"));
                produto.setMargemLucro(rs.getFloat("margem_lucro"));
                produto.setCodMarca(rs.getInt("cod_marca"));
                produto.setCodCategoria(rs.getInt("cod_categoria"));
                produtos.add(produto);
          
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao consultar: " + ex);
        } 
            
        
        return produtos;
        
    }
     public List<Produto> listarProdutoID(String disc){
        
       con = new ConnectionFactory();
       con.getConnection();
       ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        
        String sql = "SELECT * FROM produto WHERE discriminacao LIKE ? ";
        
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setString(1, "%" + disc + "%");
            rs = stmt.executeQuery();
            
            while (rs.next()) {

                Produto produto = new Produto();
                
                produto.setIdProduto(rs.getInt("id_produto"));
                produto.setCodEan(rs.getString("cod_ean"));
                produto.setDiscriminacao(rs.getString("discriminacao"));
                produto.setValorCusto(rs.getFloat("valor_custo"));
                produto.setMargemLucro(rs.getFloat("margem_lucro"));
                produto.setCodMarca(rs.getInt("cod_marca"));
                produto.setCodCategoria(rs.getInt("cod_categoria"));
                produtos.add(produto);
          
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao consultar: " + ex);
        } 
            
        
        return produtos;
        
    }
     
     
     
     
          // EXIBE CÓDIGO PARA O USUÁRIO NA TELA DE CADASTRO //
     
     public int getLastId(){
        
       con = new ConnectionFactory();
       con.getConnection();
       ResultSet rs = null;
       int id_produto = 0;
  
        
        String sql = "SELECT id_produto FROM produto ORDER BY id_produto DESC LIMIT 1";                    
        
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {

                id_produto= rs.getInt("id_produto");
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao consultar: " + ex);
        } 
            
        
        return id_produto;
        
    }
     
    public Produto populateProduto(int idProduto){
        ConnectionFactory con = new ConnectionFactory();
        con.getConnection();
        ResultSet rs = null;
        Produto p = new Produto();
         
        String sql = "SELECT * FROM produto WHERE id_produto = ?";
         
        try{
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setInt(1, idProduto);
            rs = stmt.executeQuery();
             
            while(rs.next()){
                p.setIdProduto(rs.getInt("id_produto"));
                p.setCodEan(rs.getString("cod_ean"));
                p.setDiscriminacao(rs.getString("discriminacao"));
                p.setValorCusto(rs.getFloat("valor_custo"));
                p.setMargemLucro(rs.getFloat("margem_lucro"));
                p.setCodMarca(rs.getInt("cod_marca"));
                p.setCodCategoria(rs.getInt("cod_categoria"));
            }
        }
        catch(SQLException ex){
           JOptionPane.showMessageDialog(null, "Erro na base de dados: " +ex.getMessage());
        }
         
        return p;
     }
}
