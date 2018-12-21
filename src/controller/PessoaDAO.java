/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Pessoa;
import model.EnderecoPessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Cliente;

/**
 *
 * @author bruno
 */
public class PessoaDAO {
    
    ConnectionFactory connection;
   
    
    public int inserirPessoa(Pessoa pessoa, EnderecoPessoa endereco){
        connection = new ConnectionFactory();
        connection.getConnection();
        
        PreparedStatement stmt = null;
        
        String query_pessoa = "INSERT INTO pessoa (nome, rg_ie, cpf_cnpj, email, telefone, telefone2, data_cadastro) VALUES (?, ?, ?, ?, ?, ?, ?)";
        String query_endereco = "INSERT INTO endereco_pessoa (rua, numero, cep, bairro, cidade, estado, cod_pessoa) VALUES (?,?,?,?,?,?,?)";
        
        try {
            // inserindo a pessoa;
            stmt = connection.getConnection().prepareStatement(query_pessoa, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getRgIe());
            stmt.setString(3, pessoa.getCpfCnpj());
            stmt.setString(4, pessoa.getEmail());
            stmt.setString(5, pessoa.getTelefone());
            stmt.setString(6, pessoa.getTelefone2());
            stmt.setString(7, pessoa.getDataCadastro());
            
            stmt.execute();
                
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            
            int id_pessoa = rs.getInt(1);
            
            // inserindo o endereço da pessoa
            stmt = connection.getConnection().prepareStatement(query_endereco);
            stmt.setString(1, endereco.getRua());
            stmt.setInt(2, endereco.getNumero());
            stmt.setString(3, endereco.getCep());
            stmt.setString(4, endereco.getBairro());
            stmt.setString(5, endereco.getCidade());
            stmt.setString(6, endereco.getEstado());
            stmt.setInt(7, id_pessoa);
            
            stmt.execute();
                   
            return id_pessoa;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir a pessoa! " + ex.getMessage());
            
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return -1;
    }
    
        public List<Pessoa> listarPessoa(){
        
       connection = new ConnectionFactory();
       connection.getConnection();
       ResultSet rs = null;
        
        List<Pessoa> pessoas = new ArrayList<>();
        
        String sql = "SELECT * FROM pessoa, cliente WHERE cod_pessoa = id_pessoa";
                       
                     
        
        try {
            PreparedStatement stmt = connection.getConnection().prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {

             
              Pessoa  pessoa = new Pessoa();
              
              
              pessoa.setIdPessoa(rs.getInt("id_pessoa"));
              pessoa.setNome(rs.getString("nome"));
              pessoa.setRgIe(rs.getString("rg_ie")); 
              pessoa.setCpfCnpj(rs.getString("cpf_cnpj"));
              pessoa.setEmail(rs.getString("email"));
              pessoa.setDataCadastro(rs.getString("data_cadastro"));
              
             
              pessoas.add(pessoa);
         
          
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao consultar: " + ex);
        } 
            
        
        return pessoas;
        
        
    }
       public List<Pessoa> listarPessoaNome(String nomePess){
        
       connection = new ConnectionFactory();
       connection.getConnection();
       ResultSet rs = null;
        
        List<Pessoa> pessoas = new ArrayList<>();
        
        String sql = "SELECT * FROM pessoa";
        
        try {
            PreparedStatement stmt = connection.getConnection().prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {

              Pessoa  pessoa = new Pessoa();
              
              pessoa.setIdPessoa(rs.getInt("id_pessoa"));
              pessoa.setNome(rs.getString("nome"));
              pessoa.setRgIe(rs.getString("rg_ie")); 
              pessoa.setCpfCnpj(rs.getString("cpf_cnpj"));
              pessoa.setEmail(rs.getString("email"));
              pessoa.setDataCadastro(rs.getString("data_cadastro"));
              
             
              pessoas.add(pessoa);
         
          
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao consultar: " + ex);
        } 
            
        
        return pessoas;
        
        
    }
}
