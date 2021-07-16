package DAO;

import Models.Pedido;
import Models.Pessoa;
import Utils.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PedidoDAO {

    public static int inserirPedido(Pedido pedido) {
        String sql = "INSERT INTO pedido(produto, peso, pessoaId)VALUES (?, ?, ?)";
        Connection conexao = ConexaoBanco.criarConexao();
        try {
            PreparedStatement stm;
            stm = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, pedido.getProduto());
            stm.setDouble(2, pedido.getPeso());
            stm.setInt(3, pedido.getPessoaId().getPessoaId());
            stm.execute();
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println("ERRO NO INSERT" + e);
        }
        return 0;
    }

    public static ArrayList<Pedido> BuscarPedido() {
        String sql = "SELECT * FROM pedido";
        Connection conexao = ConexaoBanco.criarConexao();
        ArrayList<Pedido> ListaPedido = new ArrayList<>();
        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet resultado = stm.executeQuery();
            while (resultado.next()) {
                int codigo = resultado.getInt("pedidoId");
                String produto = resultado.getString("produto");
                Double peso = resultado.getDouble("peso");
                Pessoa end = PessoaDAO.buscarEndPorId(resultado.getInt("nome"));
                Pedido p1 = new Pedido(codigo, produto, peso, end);
                ListaPedido.add(p1);
            }
        } catch (SQLException e) {
            System.out.println("NÃO FOI POSSIVEL FAZER A BUSCA");
        }
        return ListaPedido;
    }

    public static void DeletarPedidoPorCodigo(int codigo) {
        String sql = "DELETE FROM pedido where pessoaId = ?";
        Connection conexao = ConexaoBanco.criarConexao();
        try {
            PreparedStatement stm = conexao.prepareCall(sql);
            stm.setInt(1, codigo);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("NÃO FOI POSSIVEL DELETAR" + e);
        }
    }

    public static void AtualizarPedido(Pedido pedido) {
        String sql = "UPDATE pessoaId SET produto = ?, peso = ?, WHERE pessoaId = ?";
        Connection conexao = ConexaoBanco.criarConexao();
        try {
            PreparedStatement bla = conexao.prepareStatement(sql);
            bla.setString(1, pedido.getProduto());
            bla.setDouble(2, pedido.getPeso());
            bla.setInt(3, pedido.getPedidoId());
            bla.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("DEU ERRO AO ATUALIZAR - " + ex);
        }
    }

}
