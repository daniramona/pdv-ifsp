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
public class EnderecoCliente extends Pessoa{
    private int idEndereco;
    private String rua;
    private int numero;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;
    private int codCliente;

    public EnderecoCliente(int idEndereco, String rua, int numero, String cep, String bairro, String cidade, String estado, int codCliente) {
        this.setIdEndereco(idEndereco);
        this.setRua(rua);
        this.setNumero(numero);
        this.setCep(cep);
        this.setBairro(bairro);
        this.setCidade(cidade);
        this.setEstado(estado);
        this.setCodCliente(codCliente);
    }

    public EnderecoCliente() {
        
    }
    
    

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }
    
    
}
