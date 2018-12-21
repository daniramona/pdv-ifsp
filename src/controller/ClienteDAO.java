/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Pessoa;
import model.EnderecoPessoa;
import model.Cliente;
import model.EnderecoCliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Produto;
import view.CadastroCliente;

/**
 *
 * @author bruno
 */
public class ClienteDAO {
    
    ConnectionFactory connection;
   
    
    public int inserirCliente(Pessoa pessoa, EnderecoPessoa endereco_pessoa, Cliente cliente, EnderecoCliente endereco){
        connection = new ConnectionFactory();
        connection.getConnection();
        
        PreparedStatement stmt;
        
        String query_cliente = "INSERT INTO cliente (tipo_pessoa, data_nascimento, obs, cod_pessoa) VALUES (?, ?, ?, ?)";
        String query_endereco = "INSERT INTO endereco_cliente (rua, numero, cep, bairro, cidade, estado, cod_cliente) VALUES (?,?,?,?,?,?,?)";
        
        // insere a pessoa e seta o id dela no cliente
        PessoaDAO pessoaDAO = new PessoaDAO();
        int idPessoa = pessoaDAO.inserirPessoa(pessoa, endereco_pessoa);
        cliente.setCodPessoa(idPessoa);
        
        try {
        
            // inserindo o cliente
            stmt = connection.getConnection().prepareStatement(query_cliente, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, cliente.getTipoPessoa());
            stmt.setString(2, cliente.getDataNascimento());
            stmt.setString(3, cliente.getObs());
            stmt.setInt(4, cliente.getCodPessoa());
            
            stmt.execute();
                
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            
            int id_cliente = rs.getInt(1);
            
            // inserindo o endereço da pessoa
            stmt = connection.getConnection().prepareStatement(query_endereco);
            stmt.setString(1, endereco.getRua());
            stmt.setInt(2, endereco.getNumero());
            stmt.setString(3, endereco.getCep());
            stmt.setString(4, endereco.getBairro());
            stmt.setString(5, endereco.getCidade());
            stmt.setString(6, endereco.getEstado());
            stmt.setInt(7, id_cliente);
            
            stmt.execute();
                   
            JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso!");
            
            return id_cliente;
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir o cliente! " + ex.getMessage());
            
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return -1;
    }
    
       public List<Cliente> listarCliente(){
        
       connection = new ConnectionFactory();
       connection.getConnection();
       ResultSet rs = null;
       
       List<Cliente> clientes = new ArrayList<>();
          
       String sql = "SELECT * FROM pessoa, cliente WHERE id_pessoa = cod_pessoa ";
             
        
        try {
            PreparedStatement stmt = connection.getConnection().prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {

              Cliente cliente = new Cliente();
              
              cliente.setIdCliente(rs.getInt("id_cliente")); 
              cliente.setNome(rs.getString("nome"));
              cliente.setRgIe(rs.getString("rg_ie"));
              cliente.setCpfCnpj(rs.getString("cpf_cnpj"));
              cliente.setEmail(rs.getString("email"));
              cliente.setTelefone(rs.getString("telefone"));
              cliente.setTelefone2(rs.getString("telefone2"));
              cliente.setTipoPessoa(rs.getString("tipo_pessoa"));
              
              clientes.add(cliente);
                  
              }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao consultar: " + ex);
        } 
        
        return clientes;
            
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
        
        
        
       // EXIBI CÓDIGO DO CADASTRO PARA O USUÁRIO NA TELA DE CADASTRO //
         
         public int getLastId(){
        
       ConnectionFactory con = new ConnectionFactory();
       con.getConnection();
       ResultSet rs = null;
       int id_cliente = 0;
  
        
        String sql = "SELECT id_cliente FROM cliente ORDER BY id_cliente DESC LIMIT 1";                    
        
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {

                id_cliente = rs.getInt("id_cliente");
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao consultar: " + ex);
        } 
            
        
        return id_cliente;
        
    }
       
    
       public List<Cliente> listarCliente(String nomeClient){
        
       connection = new ConnectionFactory();
       connection.getConnection();
       ResultSet rs = null;
        
        List<Cliente> clientes = new ArrayList<>();
       
        String sql = "SELECT id_cliente, nome, rg_ie, cpf_cnpj, email, tipo_pessoa FROM pessoa, cliente WHERE cod_pessoa = id_pessoa AND nome LIKE ?";
    
        try {
            PreparedStatement stmt = connection.getConnection().prepareStatement(sql);
            stmt.setString(1, "%" + nomeClient + "%");
            rs = stmt.executeQuery();
            
            while (rs.next()) {

              Cliente cliente = new Cliente();
                
              cliente.setIdCliente(rs.getInt("id_cliente")); 
              cliente.setNome(rs.getString("nome"));
              cliente.setRgIe(rs.getString("rg_ie"));
              cliente.setCpfCnpj(rs.getString("cpf_cnpj"));
              cliente.setEmail(rs.getString("email"));
              cliente.setTipoPessoa(rs.getString("tipo_pessoa"));
              clientes.add(cliente);
             
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao consultar: " + ex);
        } 
            
        
        return clientes;
        
        
    }
       
      public void consultarAlterarCategoria(String categoria, int idC) throws SQLException{
        
        connection = new ConnectionFactory();
        connection.getConnection();
        
            CadastroCliente cadCli = new CadastroCliente();
        
        String sql = " SELECT *  ";
        try {
            PreparedStatement stmt = connection.getConnection().prepareStatement(sql);
            stmt.setString(1, categoria);
            stmt.setInt(2, idC);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Categoria alterada com sucesso!");
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    public List<Object> populateCliente(int idCliente){
        
        connection = new ConnectionFactory();
        connection.getConnection();
        ResultSet rs = null;
        List<Object> obj = new ArrayList<>();
        
        String sql = " SELECT * from cliente, pessoa, endereco_cliente, endereco_pessoa where cliente.cod_pessoa = pessoa.id_pessoa and cliente.id_cliente = endereco_cliente.cod_cliente and endereco_pessoa.cod_pessoa = pessoa.id_pessoa and cliente.id_cliente = ?";
        try{
            PreparedStatement stmt = connection.getConnection().prepareStatement(sql);
            stmt.setInt(1, idCliente);
            rs = stmt.executeQuery();
            
            
            while (rs.next()) {

              Pessoa  pessoa = new Pessoa();
              
              pessoa.setIdPessoa(rs.getInt("id_pessoa"));
              pessoa.setNome(rs.getString("nome"));
              pessoa.setRgIe(rs.getString("rg_ie")); 
              pessoa.setCpfCnpj(rs.getString("cpf_cnpj"));
              pessoa.setEmail(rs.getString("email"));
              pessoa.setDataCadastro(rs.getString("data_cadastro"));
              
              obj.add(pessoa);
              
              Cliente cliente = new Cliente();
              
              cliente.setIdCliente(rs.getInt("id_cliente"));
              cliente.setTipoPessoa(rs.getString("tipo_pessoa"));
              cliente.setDataNascimento(rs.getDate("data_nascimento").toString());
              cliente.setObs(rs.getString("obs"));
              cliente.setCodPessoa(rs.getInt("cod_pessoa"));
              
              obj.add(cliente);
              
              EnderecoPessoa endpes = new EnderecoPessoa();
              
              endpes.setIdEndereco(rs.getInt("endereco_pessoa.id_endereco"));
              endpes.setRua(rs.getString("endereco_pessoa.rua"));
              endpes.setNumero(rs.getInt("endereco_pessoa.numero"));
              endpes.setCep(rs.getString("endereco_pessoa.cep"));
              endpes.setBairro(rs.getString("endereco_pessoa.bairro"));
              endpes.setCidade(rs.getString("endereco_pessoa.cidade"));
              endpes.setEstado(rs.getString("endereco_pessoa.estado"));
              endpes.setCodPessoa(rs.getInt("endereco_pessoa.cod_pessoa"));
              
              obj.add(endpes);
              
              EnderecoCliente endcli = new EnderecoCliente();
              
              endcli.setIdEndereco(rs.getInt("endereco_cliente.id_endereco"));
              endcli.setRua(rs.getString("endereco_cliente.rua"));
              endcli.setNumero(rs.getInt("endereco_cliente.numero"));
              endcli.setCep(rs.getString("endereco_cliente.cep"));
              endcli.setBairro(rs.getString("endereco_cliente.bairro"));
              endcli.setCidade(rs.getString("endereco_cliente.cidade"));
              endcli.setEstado(rs.getString("endereco_cliente.estado"));
              endcli.setCodCliente(rs.getInt("endereco_cliente.cod_cliente"));
              
              obj.add(endcli);
              
              
            }
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
        
        return obj;
        
    }    

    public void ExcluirCliente(int idCliente) {
        connection = new ConnectionFactory();
        connection.getConnection();
        
        PreparedStatement stmt;
        
        
        List<Object> list = new ArrayList<>(this.populateCliente(idCliente));
        Cliente c = (Cliente) list.get(1);
        EnderecoCliente endcli = (EnderecoCliente) list.get(3);
        
        String query_cliente = "DELETE FROM cliente WHERE id_cliente = ?";
        /* String query_endereco_cliente = "DELETE FROM endereco_cliente WHERE id_endereco_cliente = ?"; */
        
        try {
        
            // inserindo o cliente
            stmt = connection.getConnection().prepareStatement(query_cliente);
            stmt.setInt(1, c.getIdCliente());    
            stmt.execute();
                
            // inserindo o cliente
           /* stmt = connection.getConnection().prepareStatement(query_endereco_cliente);
            stmt.setInt(1, endcli.getIdEndereco());
            stmt.execute(); */
                   
            JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o cliente! " + ex.getMessage());
            
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 


}

