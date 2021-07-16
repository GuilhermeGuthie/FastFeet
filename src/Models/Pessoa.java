package Models;

public class Pessoa {

    public Pessoa(String nome, String telefone, Endereco enderecoId) {
        this.nome = nome;
        this.telefone = telefone;
        this.enderecoId = enderecoId;
    }

    public Pessoa(int pessoaId, String nome, String telefone, Endereco enderecoId) {
        this.pessoaId = pessoaId;
        this.nome = nome;
        this.telefone = telefone;
        this.enderecoId = enderecoId;
    }

    private int pessoaId;
    private String nome;
    private String telefone;
    private Endereco enderecoId;

    public int getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(int pessoaId) {
        this.pessoaId = pessoaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Endereco enderecoId) {
        this.enderecoId = enderecoId;
    }
}
