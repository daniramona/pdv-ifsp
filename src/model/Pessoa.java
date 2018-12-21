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
public class Pessoa {
    private int id_pessoa;
    private String nome;
    private String rg_ie;
    private String cpf_cnpj;
    private String email;
    private String telefone;
    private String telefone2;
    private String data_cadastro;

    
    public Pessoa(int id_pessoa, String nome, String rg_ie, String cpf_cnpj, String email, String telefone, String telefone2, String data_cadastro){
        this.setIdPessoa(id_pessoa);
        this.setNome(nome);
        this.setRgIe(rg_ie);
        this.setCpfCnpj(cpf_cnpj);
        this.setEmail(email);
        this.setTelefone(telefone);
        this.setTelefone2(telefone2);
        this.setDataCadastro(data_cadastro);
    }
    
    public Pessoa(){
    
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public int getIdPessoa() {
        return id_pessoa;
    }

    public void setIdPessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRgIe() {
        return rg_ie;
    }

    public void setRgIe(String rg_ie) {
        this.rg_ie = rg_ie;
    }

    public String getCpfCnpj() {
        return cpf_cnpj;
    }

    public void setCpfCnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataCadastro() {
        return data_cadastro;
    }

    public void setDataCadastro(String data_cadastro) {
        this.data_cadastro = data_cadastro;
    }
}
