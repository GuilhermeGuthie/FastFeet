package DAO;

import Models.Endereco;
import Utils.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EnderecoDAO {

    public static int inserirEndereco(Endereco endereco) {
        String sql = "INSERT INTO endereco(cidade, estado, logradouro)VALUES (?, ?, ?)";
        Connection conexao = ConexaoBanco.criarConexao();
        try {
            PreparedStatement stm;
            stm = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, endereco.getCidade());
            stm.setString(2, endereco.getEstado());
            stm.setString(3, endereco.getLogradouro());
            stm.execute();
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);

        } catch (SQLException e) {
            System.out.println("Não funcionou a conexão" + e);

        }
        return 0;
    }

    public static Endereco buscarEndPorId(int codigo) {
        String sql = "SELECT * FROM endereco WHERE enderecoId = ?";
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
}
