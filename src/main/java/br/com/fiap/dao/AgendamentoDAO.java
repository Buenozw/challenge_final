package br.com.fiap.dao;

import br.com.fiap.beans.Agendamento;
import br.com.fiap.conexao.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoDAO {

    public Connection minhaConexao;

    public AgendamentoDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao  = new ConexaoFactory().conexao();
    }

    // Inserir
    public String inserir(Agendamento agendamento) throws SQLException {
        PreparedStatement stmt =
        minhaConexao.prepareStatement("Insert into AGENDAMENTO (DATAHORA_AGENDAMENTO, TIPO_AGENDAMENTO) values (TO_DATE(?, 'dd/mm/yyyy hh24:mi'), ?)");
        stmt.setString(1, agendamento.getDatahora());
        stmt.setString(2, agendamento.getTipoExame());

        stmt.execute();
        stmt.close();

        return "Agendamento cadastrado com sucesso✅";
    }

    // Delete
    public String deletar(int idAgendamento) throws SQLException {
        PreparedStatement stmt =
        minhaConexao.prepareStatement("Delete from AGENDAMENTO where ID_AGENDAMENTO = ?");
        stmt.setInt(1, idAgendamento);

        stmt.execute();
        stmt.close();

        return "Agendamento deletado com sucesso✅!";
    }

    // Atualizar
    public String atualizar (Agendamento agendamento) throws SQLException {
        PreparedStatement stmt =
        minhaConexao.prepareStatement("Update AGENDAMENTO set DATAHORA_AGENDAMENTO = TO_DATE(?, 'DD/MM/YYYY HH24:MI'), TIPO_AGENDAMENTO = ? where ID_AGENDAMENTO = ?");

        stmt.setString(1, agendamento.getDatahora());
        stmt.setString(2, agendamento.getTipoExame());
        stmt.setInt(3, agendamento.getIdAgendamento());

        stmt.executeUpdate();
        stmt.close();

        return "Agendamento atualizado com sucesso✅!";
    }

    // Selecionar
    public List<Agendamento> selecionar() throws SQLException {
        ArrayList<Agendamento> listAgendamento = new ArrayList<Agendamento>();

        PreparedStatement stmt =
        minhaConexao.prepareStatement("select * from AGENDAMENTO");

        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            Agendamento objAgendamento = new Agendamento();
            objAgendamento.setDatahora(rs.getString("DATAHORA_AGENDAMENTO"));
            objAgendamento.setTipoExame(rs.getString("TIPO_AGENDAMENTO"));
            objAgendamento.setIdAgendamento(rs.getInt("ID_AGENDAMENTO"));
            listAgendamento.add(objAgendamento);
        }
        return listAgendamento;
    }
}
