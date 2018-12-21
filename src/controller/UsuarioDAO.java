
package controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Usuario;

public class UsuarioDAO {
    ConnectionFactory con;
    
    public void inserirUsuario(Usuario u){
        con = new ConnectionFactory();
        con.getConnection();
        
        String sql = "INSERT INTO usuario (nome, usuario, senha) values (?,?,?)";
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getUsuario());
            stmt.setString(3, u.getSenha());
            stmt.executeUpdate();
            
            
            JOptionPane.showMessageDialog(null,"Usuário inserido com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao cadastrar o usuário!");
        }
    }
    
    public boolean validarUsuario(Usuario u) throws NoSuchAlgorithmException{
        con = new ConnectionFactory();
        con.getConnection();
        
        String senha = sha1(u.getSenha());
        
        String query = "SELECT * FROM usuario WHERE usuario = '" + u.getUsuario() + "' AND senha = '" + senha + "'";
        
        try{
            PreparedStatement stmt = con.getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                return true;
            }
            return false;
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao cadastrar o usuário!");
        }
        
        return false;
    }

     static String sha1(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
         
        return sb.toString();
    }
     
     public List<Usuario> listarUsuario(){
        
       con = new ConnectionFactory();
       con.getConnection();
       ResultSet rs = null;
        
        List<Usuario> usuarios = new ArrayList<>();
        
        String sql = "SELECT * FROM usuario";
        
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {

                Usuario usuario = new Usuario();
               
                usuario.setIdUsuario(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setSenha(rs.getString("senha"));
                usuarios.add(usuario);
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao consultar: " + ex);
        } 
            
        
        return usuarios;
        
    }
     public List<Usuario> listarUsuarioNome(String nomeUsu){
        
       con = new ConnectionFactory();
       con.getConnection();
       ResultSet rs = null;
        
        List<Usuario> usuarios = new ArrayList<>();
        
        String sql = "SELECT * FROM usuario WHERE nome LIKE ? "; 
        
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setString(1, "%" + nomeUsu + "%");
            rs = stmt.executeQuery();
            
            while (rs.next()) {

                Usuario usuario = new Usuario();
               
                usuario.setIdUsuario(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setSenha(rs.getString("senha"));
                usuarios.add(usuario);
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao consultar: " + ex);
        } 
            
        
        return usuarios;
        
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
     
     public int getLastId(){
        
       con = new ConnectionFactory();
       con.getConnection();
       ResultSet rs = null;
       int id = 0;
  
        
        String sql = "SELECT id FROM usuario ORDER BY id DESC LIMIT 1";                    
        
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {

                id= rs.getInt("id");
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao consultar: " + ex);
        } 
            
        
        return id;
        
    }
     
     
     
}
