/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author al1610597
 */
public class Usuario {
    
    private int idUsuario;
    private String nome;
    private String usuario;
    private String senha;

    public Usuario(int idUsuario, String nome, String usuario, String senha){
        this.setIdUsuario(idUsuario);
        this.setNome(nome);
        this.setUsuario(usuario);
        this.setSenha(senha);
    }

    public Usuario() {
        
    }
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
}
