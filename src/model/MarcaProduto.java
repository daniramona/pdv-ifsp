package model;

/**
 *
 * @author bruno
 */
public class MarcaProduto {
    private int idMarcaProduto;
    private String descricao;

    public MarcaProduto(int idMarcaProduto, String descricao) {
        this.setIdMarcaProduto(idMarcaProduto);
        this.setDescricao(descricao);
    }

    public MarcaProduto() {
       
    }
    
    public int getIdMarcaProduto() {
        return idMarcaProduto;
    }

    public void setIdMarcaProduto(int idMarcaProduto) {
        this.idMarcaProduto = idMarcaProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
