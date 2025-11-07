package br.com.fiap.dao;

import br.com.fiap.beans.Agendamento;
import br.com.fiap.beans.Consulta;
import br.com.fiap.conexao.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO {

    public Connection minhaConexao;

    public ConsultaDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao  = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(Consulta consulta) throws SQLException {
        PreparedStatement stmt =
        minhaConexao.prepareStatement("Insert into CONSULTA (DATAHORA_CONSULTA, DESCRICAO_CONSULTA, NOME_CONSULTA)  values (TO_DATE(?, 'dd/mm/yyyy hh24:mi'), ?, ?)");
        stmt.setString(1, consulta.getDatahora_consulta());
        stmt.setString(2, consulta.getDescricao_consulta());
        stmt.setString(3, consulta.getNome_consulta());

        stmt.execute();
        stmt.close();

        return "Consulta cadastrada com sucesso ✅";
    }

    // Delete
    public String deletar(int idConsulta) throws SQLException {
        PreparedStatement stmt =
        minhaConexao.prepareStatement("Delete from CONSULTA where ID_CONSULTA = ?");
        stmt.setInt(1, idConsulta);

        stmt.execute();
        stmt.close();

        return "Consulta deletado com sucesso ✅!";
    }

    // UpDate
    public String atualizar (Consulta consulta) throws SQLException {
        PreparedStatement stmt =
        minhaConexao.prepareStatement("Update CONSULTA set DATAHORA_CONSULTA = TO_DATE(?, 'DD/MM/YYYY HH24:MI'), DESCRICAO_CONSULTA = ?, NOME_CONSULTA = ? where ID_CONSULTA = ?");

        stmt.setInt(1, consulta.getId_consulta());
        stmt.setString(2, consulta.getDatahora_consulta());
        stmt.setString(3, consulta.getDescricao_consulta());
        stmt.setString(4, consulta.getNome_consulta());

        stmt.executeUpdate();
        stmt.close();

        return "Consulta atualizado com sucesso ✅!";
    }

    // Select
    public List<Consulta> selecionar() throws SQLException {
        ArrayList<Consulta> listConsulta = new ArrayList<Consulta>();

        PreparedStatement stmt =
        minhaConexao.prepareStatement("SELECT * FROM CONSULTA");

        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            Consulta objConsulta = new Consulta();
            objConsulta.setId_consulta(rs.getInt("ID_CONSULTA"));
            objConsulta.setDatahora_consulta(rs.getString("DATAHORA_CONSULTA"));
            objConsulta.setDescricao_consulta(rs.getString("DESCRICAO_CONSULTA"));
            objConsulta.setNome_consulta(rs.getString("NOME_CONSULTA"));
            listConsulta.add(objConsulta);
        }
        return listConsulta;
    }
}
