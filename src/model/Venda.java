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
public class Venda {

    private int idVenda;
    private String dataVenda;
    private String tipoVenda;
    private int codEan;
    private String notaFiscal;
    private int codCliente;

    public Venda(int idVenda, String tipoVenda, int codEan, String notaFiscal, int codCliente) {
        this.setIdVenda(idVenda);
        this.setTipoVenda(tipoVenda);
        this.setCodEan(codEan);
        this.setNotaFiscal(notaFiscal);
        this.setCodCliente(codCliente);
    }
    
    

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getTipoVenda() {
        return tipoVenda;
    }

    public void setTipoVenda(String tipoVenda) {
        this.tipoVenda = tipoVenda;
    }

    public int getCodEan() {
        return codEan;
    }

    public void setCodEan(int codEan) {
        this.codEan = codEan;
    }

    public String getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(String notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }
    
}
