/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author bruno
 */
public class CategoriaProduto {
    private int idCategoria;
    private String descricao;

    public CategoriaProduto(int idCategoria, String descricao) {
        this.setIdCategoria(idCategoria);
        this.setDescricao(descricao);
    }

    public CategoriaProduto() {
        
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
