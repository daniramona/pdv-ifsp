package model;

/**
 *
 * @author brunosartori
 */
public class VendaCorpo {
    private int idCorpo;
    private int quantidade;
    private float valorUnitario;
    private float valorTotal;
    private int codProduto;
    private int codVenda;

    public VendaCorpo(int idCorpo, int quantidade, float valorUnitario, float valorTotal, int codProduto, int codVenda) {
        this.setIdCorpo(idCorpo);
        this.setQuantidade(quantidade);
        this.setValorUnitario(valorUnitario);
        this.setValorTotal(valorTotal);
        this.setCodProduto(codProduto);
        this.setCodVenda(codVenda);
    }
    
     public VendaCorpo(int idCorpo, int quantidade, float valorUnitario, int codProduto, int codVenda) {
        this.setIdCorpo(idCorpo);
        this.setQuantidade(quantidade);
        this.setValorUnitario(valorUnitario);
        this.setValorTotal(valorUnitario, quantidade);
        this.setCodProduto(codProduto);
        this.setCodVenda(codVenda);
    }
    
    public int getIdCorpo() {
        return idCorpo;
    }

    public void setIdCorpo(int idCorpo) {
        this.idCorpo = idCorpo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorUnitario, int quantidade) {
        this.valorTotal = valorUnitario * quantidade;
    }
    
    public void setValorTotal(float valorTotal){
        this.valorTotal = valorTotal;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }
}
