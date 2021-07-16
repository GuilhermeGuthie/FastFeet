package Models;

public class Pedido {

    private int pedidoId;
    private String produto;
    private double peso;
    private Pessoa pessoaId;

    public Pedido(String produto, double peso, Pessoa pessoaId) {
        this.produto = produto;
        this.peso = peso;
        this.pessoaId = pessoaId;
    }

    public Pedido(int pedidoId, String produto, double peso, Pessoa pessoaId) {
        this.pedidoId = pedidoId;
        this.produto = produto;
        this.peso = peso;
        this.pessoaId = pessoaId;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Pessoa getPessoaId() {
        return pessoaId;
    }

    public void setPessoa(Pessoa pessoaId) {
        this.pessoaId = pessoaId;
    }

}
