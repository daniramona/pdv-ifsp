package model;

/**
 *
 * @author Bruno Sartori <brunosartori.webmaster@gmail.com>
 */
public class Cliente extends Pessoa{
    private int idCliente;
    private String tipoPessoa;
    private String dataNascimento;
    private String obs;
    private int codPessoa;
    
    public Cliente(int idCliente, String tipoPessoa, String dataNascimento, String obs, int codPessoa){
        this.setIdCliente(idCliente);
        this.setTipoPessoa(tipoPessoa);
        this.setDataNascimento(dataNascimento);
        this.setObs(obs);
        this.setCodPessoa(codPessoa);
    }

    public Cliente() {
        
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
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
