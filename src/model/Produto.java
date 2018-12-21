package model;

/**
 *
 * @author bruno
 */
public class Produto {
    private int idProduto;
    private String codEan;
    private String discriminacao;
    private float valorCusto;
    private float margemLucro;
    private float valorUnitario;
    private int codMarca;
    private int codCategoria;
    private int quantidade;

    public Produto(int idProduto, String codEan, String discriminacao, float valorCusto, float margemLucro, int codMarca, int codCategoria) {
        this.setIdProduto(idProduto);
        this.setCodEan(codEan);
        this.setDiscriminacao(discriminacao);
        this.setValorCusto(valorCusto);
        this.setMargemLucro(margemLucro);
        this.setValorUnitario();
        this.setCodMarca(codMarca);
        this.setCodCategoria(codCategoria);
    }

    public Produto() {
        
    }
    
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    
     public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getCodEan() {
        return codEan;
    }

    public void setCodEan(String codEan) {
        this.codEan = codEan;
    }

    public String getDiscriminacao() {
        return discriminacao;
    }

    public void setDiscriminacao(String discriminacao) {
        this.discriminacao = discriminacao;
    }

    public float getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(float valorCusto) {
        this.valorCusto = valorCusto;
    }

    public void setMargemLucro(float margemLucro){
       this.margemLucro = margemLucro;
    }
    
    public float getMargemLucro(){
        return this.margemLucro;
    }
    
    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario() {
        this.valorUnitario = this.getValorCusto() + (this.getValorCusto() * this.getMargemLucro() / 100);
    }

    public int getCodMarca() {
        return codMarca;
    }

    public void setCodMarca(int codMarca) {
        this.codMarca = codMarca;
    }

    public int getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(int codCategoria) {
        this.codCategoria = codCategoria;
    }
}
