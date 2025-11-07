package br.com.fiap.dao;

import br.com.fiap.beans.Notificacao;
import br.com.fiap.beans.RecuperacaoSenha;
import br.com.fiap.beans.Remedios;
import br.com.fiap.conexao.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RemediosDAO {

    public Connection minhaConexao;

    public RemediosDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(Remedios remedios) throws SQLException {
        PreparedStatement stmt =
                minhaConexao.prepareStatement("Insert into REMEDIOS (NOME_REMEDIO, DESCRICAO_REMEDIO, PRECO_REMEDIO, QUANTIDADE_REMEDIO) values (?, ?, ?, ?)");
        stmt.setString(1, remedios.getNome_remedio());
        stmt.setString(2, remedios.getDescricao_remedio());
        stmt.setDouble(3, remedios.getPreco_remedio());
        stmt.setString(4, remedios.getQuantidade_remedio());

        stmt.execute();
        stmt.close();

        return "Rémedios cadastrado com sucesso✅";
    }

    // Delete
    public String deletar(int idRemedios) throws SQLException {
        PreparedStatement stmt =
                minhaConexao.prepareStatement("Delete from REMEDIOS where ID_REMEDIO = ?");
        stmt.setInt(1, idRemedios);

        stmt.execute();
        stmt.close();

        return "Remédio deletado com sucesso✅!";
    }

    // UpDate
    public String atualizar (Remedios remedios) throws SQLException {
        PreparedStatement stmt =
                minhaConexao.prepareStatement("Update REMEDIOS set NOME_REMEDIO = ?, DESCRICAO_REMEDIO = ?, PRECO_REMEDIO = ?  where ID_REMEDIO = ?");

        stmt.setString(1, remedios.getNome_remedio());
        stmt.setString(2, remedios.getDescricao_remedio());
        stmt.setDouble(3, remedios.getPreco_remedio());
        stmt.setInt(4, remedios.getId_remedio());

        stmt.executeUpdate();
        stmt.close();

        return "Remédio atualizado com sucesso ✅!";
    }

    // Select
    public List<Remedios> selecionar() throws SQLException {
        ArrayList<Remedios> listRemedios = new ArrayList<Remedios>();

        PreparedStatement stmt =
                minhaConexao.prepareStatement("select * from REMEDIOS");
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            Remedios objRemedios = new Remedios();
            objRemedios.setId_remedio(rs.getInt("ID_REMEDIO"));
            objRemedios.setNome_remedio(rs.getString("NOME_REMEDIO"));
            objRemedios.setDescricao_remedio(rs.getString("DESCRICAO_REMEDIO"));
            objRemedios.setPreco_remedio(rs.getDouble("PRECO_REMEDIO"));
            listRemedios.add(objRemedios);


        }
        return listRemedios;
    }


}
