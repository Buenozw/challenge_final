package br.com.fiap.dao;

import br.com.fiap.beans.Endereco;
import br.com.fiap.conexao.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAO {

    public Connection minhaConexao;

    public EnderecoDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao  = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(Endereco endereco) throws SQLException {
        PreparedStatement stmt =
        minhaConexao.prepareStatement("Insert into ENDERECO (RUA, NUMERO, CEP)  values (?, ?, ?)");
        stmt.setString(1, endereco.getRua());
        stmt.setInt(2, endereco.getNumero());
        stmt.setInt(3, endereco.getCep());

        stmt.execute();
        stmt.close();

        return "Endereço cadastrado com sucesso✅";
    }

    // Delete
    public String deletar(int cep) throws SQLException {
        PreparedStatement stmt =
        minhaConexao.prepareStatement("Delete from ENDERECO where CEP = ?");
        stmt.setInt(1, cep);

        stmt.execute();
        stmt.close();

        return "Endereço deletado com sucesso✅!";
    }

    // UpDate
    public String atualizar (Endereco endereco) throws SQLException {
        PreparedStatement stmt =
        minhaConexao.prepareStatement("Update ENDERECO set RUA = ?, NUMERO = ? where CEP = ?");

        stmt.setString(1, endereco.getRua());
        stmt.setInt(2, endereco.getNumero());
        stmt.setInt(3, endereco.getCep());

        stmt.executeUpdate();
        stmt.close();

        return "Endereço atualizado com sucesso✅!";
    }

    // Select
    public List<Endereco> selecionar() throws SQLException {
        ArrayList<Endereco> listEndereco = new ArrayList<Endereco>();

        PreparedStatement stmt =
        minhaConexao.prepareStatement("select * from ENDERECO");

        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            Endereco objEndereco = new Endereco();
            objEndereco.setRua(rs.getString("RUA"));
            objEndereco.setNumero(rs.getInt("NUMERO"));
            objEndereco.setCep(rs.getInt("CEP"));
            listEndereco.add(objEndereco);
        }
        return listEndereco;
    }
}
