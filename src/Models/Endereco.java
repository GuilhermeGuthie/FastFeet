package Models;

public class Endereco {

    public Endereco(String cidade, String estado, String logradouro) {
        this.enderecoId = enderecoId;
        this.estado = estado;
        this.cidade = cidade;
        this.logradouro = logradouro;
    }
    private int enderecoId;
    private String estado;
    private String cidade;
    private String logradouro;

    public int getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(int enderecoId) {
        this.enderecoId = enderecoId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }   

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }


}
