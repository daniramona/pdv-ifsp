/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Pessoa;
import model.EnderecoPessoa;
import model.Fornecedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Usuario;

/**
 *
 * @author bruno
 */
public class FornecedorDAO {
    
    ConnectionFactory connection;
   
    
    public int inserirFornecedor(Pessoa pessoa, EnderecoPessoa endereco_pessoa, Fornecedor fornecedor){
        connection = new ConnectionFactory();
        connection.getConnection();
        
        PreparedStatement stmt;
        
        String query_fornecedor = "INSERT INTO fornecedor (nome_fantasia, obs, tipo_pessoa, cod_pessoa) VALUES (?, ?, ?, ?)";
        
        // insere a pessoa e seta o id dela no cliente
        PessoaDAO pessoaDAO = new PessoaDAO();
        int idPessoa = pessoaDAO.inserirPessoa(pessoa, endereco_pessoa);
        fornecedor.setCodPessoa(idPessoa);
        
        try {
        
            // inserindo o fornecedor
            stmt = connection.getConnection().prepareStatement(query_fornecedor, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, fornecedor.getNomeFantasia());
            stmt.setString(2, fornecedor.getObs());
            stmt.setString(3, "Jurídica");
            stmt.setInt(4, fornecedor.getCodPessoa());
            
            stmt.execute();
                
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            
            int id_fornecedor = rs.getInt(1);
                   
            JOptionPane.showMessageDialog(null, "Fornecedor inserido com sucesso!");
            
            return id_fornecedor;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir o fornecedor!");
            
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return -1;
    }
    
         public List<Fornecedor> listarFornecedor(){
        
       connection = new ConnectionFactory();
       connection.getConnection();
       ResultSet rs = null;
        
        List<Fornecedor> fornecedores = new ArrayList<>();
        
        String sql = "SELECT id_fornecedor, nome_fantasia, cpf_cnpj, rg_ie, email, tipo_pessoa FROM fornecedor, pessoa WHERE cod_pessoa = id_pessoa";
        
        try {
            PreparedStatement stmt = connection.getConnection().prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {

                Fornecedor fornecedor = new Fornecedor();
               
                fornecedor.setIdFornecedor(rs.getInt("id_fornecedor"));
                fornecedor.setNomeFantasia(rs.getString("nome_fantasia"));
                fornecedor.setCpfCnpj(rs.getString("cpf_cnpj"));
                fornecedor.setRgIe(rs.getString("rg_ie"));
                fornecedor.setEmail(rs.getString("email"));
                fornecedores.add(fornecedor);
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao consultar: " + ex);
        } 
            
        
        return fornecedores;
        
    }
    
         
    // COMBO BOX ESTADOS //
         
        public ResultSet toComboBox() {
        ConnectionFactory con = new ConnectionFactory();
        con.getConnection();
        PreparedStatement stmt = null;
        
        try{
            
            // Your database connections  
            ResultSet rs;
            String sql = "SELECT id, uf from estados";
            
            stmt = con.getConnection().prepareStatement(sql);
            
            rs = stmt.executeQuery();
            return rs;
        }
        catch(Exception e){
            System.out.println("Error"+e);
            return null;
        }    
    }
        
    // COMBO BOX CIDADES //
         
        public ResultSet toComboBoxCidade(int idEstado) {
        ConnectionFactory con = new ConnectionFactory();
        con.getConnection();
        PreparedStatement stmt = null;
        
        try{
            
            // Your database connections  
            ResultSet rs;
            String sql = "SELECT id, nome from cidades where estado = ?";
            
            stmt = con.getConnection().prepareStatement(sql);
            stmt.setInt(1, idEstado);
            rs = stmt.executeQuery();
            return rs;
        }
        catch(Exception e){
            System.out.println("Error"+e);
            return null;
        }    
    }    
     
    // EXIBE CÓDIGO PARA O USUÁRIO NA TELA DE CADASTRO //
     
     public int getLastId() {
        
       ConnectionFactory con = new ConnectionFactory();
       con.getConnection();
       ResultSet rs = null;
       int id_fornecedor = 0;
  
        
        String sql = "SELECT id_fornecedor FROM fornecedor ORDER BY id_fornecedor DESC LIMIT 1";                    
        
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {

                id_fornecedor= rs.getInt("id_fornecedor");
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao consultar: " + ex);
        } 
            
        
        return id_fornecedor;
        
    }
         
         
         
         // LISTA FORNECEDORES NA JTABLE //
         
         
     public List<Fornecedor> listarFornecedor(String nomeForn){
        
       connection = new ConnectionFactory();
       connection.getConnection();
       ResultSet rs = null;
        
        List<Fornecedor> fornecedores = new ArrayList<>();
        
        String sql = "SELECT id_fornecedor, nome_fantasia, cpf_cnpj, rg_ie, email, tipo_pessoa FROM fornecedor, pessoa WHERE cod_pessoa = id_pessoa AND nome_fantasia LIKE ?";
        
        try {
            PreparedStatement stmt = connection.getConnection().prepareStatement(sql);
            stmt.setString(1, "%" + nomeForn + "%");
            rs = stmt.executeQuery();
            
            while (rs.next()) {

                Fornecedor fornecedor = new Fornecedor();
               
                fornecedor.setIdFornecedor(rs.getInt("id_fornecedor"));
                fornecedor.setNomeFantasia(rs.getString("nome_fantasia"));
                fornecedor.setCpfCnpj(rs.getString("cpf_cnpj"));
                fornecedor.setRgIe(rs.getString("rg_ie"));
                fornecedor.setEmail(rs.getString("email"));
                fornecedores.add(fornecedor);
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao consultar: " + ex);
        } 
            
        
        return fornecedores;
        
    }
    public void ExcluirFornecedor(int idFornecedor) {
        connection = new ConnectionFactory();
        connection.getConnection();
        
        PreparedStatement stmt;
        
        String query_fornecedor = "DELETE FROM fornecedor WHERE id_fornecedor = ?";
        
        try {
            // inserindo o cliente
            stmt = connection.getConnection().prepareStatement(query_fornecedor);
            stmt.setInt(1, idFornecedor);    
            stmt.execute();
                
            JOptionPane.showMessageDialog(null, "Fornecedor excluido com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o Fornecedor! " + ex.getMessage());
            
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     

}

