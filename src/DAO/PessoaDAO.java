package DAO;

import Models.Pessoa;
import Models.Endereco;
import Utils.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PessoaDAO {

    public static int inserirPessoa(Pessoa pessoa) {
        String sql = "INSERT INTO pessoa(nome, telefone, enderecoId)VALUES (?,?,?)";
        Connection conexao = ConexaoBanco.criarConexao();
        try {
            PreparedStatement stm;
            stm = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, pessoa.getNome());
            stm.setString(2, pessoa.getTelefone());
            stm.setInt(3, pessoa.getEnderecoId().getEnderecoId());
            stm.execute();
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println(" CONEXÃO FALHOU" + e);
        }
        return 0;
    }

    public static ArrayList<Pessoa> BuscarPessoas() {
        String sql = "SELECT * FROM pessoa ORDER BY pessoaId";
        Connection conexao = ConexaoBanco.criarConexao();
        ArrayList<Pessoa> listaPessoa = new ArrayList<>();
        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet resultado = stm.executeQuery();
            while (resultado.next()) {
                int pessoaId = resultado.getInt("pessoaId");
                String nome = resultado.getString("nome");
                String telefone = resultado.getString("telefone");
                Endereco end = EnderecoDAO.buscarEndPorId(resultado.getInt("enderecoId"));
                Pessoa p1 = new Pessoa(pessoaId, nome, telefone, end);
                listaPessoa.add(p1);
            }
        } catch (SQLException e) {
            System.out.println("Não fui buscar ninguem " + e);
        }
        return listaPessoa;
    }

    public static void DeletarPessoaPorCodigo(int codigo) {
        String sql = "DELETE FROM pessoa where pessoaId = ?";
        Connection conexao = ConexaoBanco.criarConexao();
        try {
            PreparedStatement stm = conexao.prepareCall(sql);
            stm.setInt(1, codigo);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("DEU ERRO AO DELETAR" + e);
        }
    }

    public static Pessoa buscarEndPorId(int codigo) {
        String sql = "SELECT * FROM pessoa WHERE pessoaId = ?";
        Connection conexao = ConexaoBanco.criarConexao();
        try {
            PreparedStatement stm = conexao.prepareCall(sql);
            stm.setInt(1, codigo);
            stm.execute();

        } catch (SQLException e) {
            System.out.println("DEU ERRO AO BUSCAR " + e);
        }
        return null;
    }

    public static void AtualizarUsuario(Pessoa pessoa) {
        String sql = "UPDATE pessoa SET nome = ?, telefone = ?, WHERE pessoaId = ?";
        Connection conexao = ConexaoBanco.criarConexao();
        try {
            PreparedStatement bla = conexao.prepareStatement(sql);
            bla.setString(1, pessoa.getNome());
            bla.setString(2, pessoa.getTelefone());
            bla.setInt(3, pessoa.getPessoaId());
            bla.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("DEU ERRO AO ATUALIZAR - " + ex);
        }
    }

}
