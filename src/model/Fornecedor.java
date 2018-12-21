/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author brunosartori
 */
public class Fornecedor extends Pessoa{
    private int idFornecedor;
    private String nomeFantasia;
    private String obs;
    private String tipo_pessoa;
    private int codPessoa;
            
    public Fornecedor(int idFornecedor, String nomeFantasia, String obs, int codPessoa) {
        this.setIdFornecedor(idFornecedor);
        this.setNomeFantasia(nomeFantasia);
        this.setObs(obs);
        this.setCodPessoa(codPessoa);
        this.setTipoPessoa(tipo_pessoa);
    }

    public Fornecedor() {
        
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public String getTipoPessoa() {
        return tipo_pessoa;
    }

    public void setTipoPessoa(String tipo_pessoa) {
        this.tipo_pessoa = tipo_pessoa;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    
    public int getCodPessoa() {
        return codPessoa;
    }

    public void setCodPessoa(int codPessoa) {
        this.codPessoa = codPessoa;
    }
    
}
