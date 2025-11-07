package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Agendamento;
import br.com.fiap.dao.AgendamentoDAO;

public class AgendamentoBO {

    AgendamentoDAO agendamentoDAO;

    // Selecionar
    public ArrayList<Agendamento> selecionarBo() throws ClassNotFoundException, SQLException {
        agendamentoDAO = new AgendamentoDAO();
        return (ArrayList<Agendamento>) agendamentoDAO.selecionar();
    }

    // Inserir
    public void inserirBo(Agendamento agendamento) throws ClassNotFoundException, SQLException {
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        agendamentoDAO.inserir(agendamento);
    }

    // Atualizar
    public void atualizarBo(Agendamento agendamento) throws ClassNotFoundException, SQLException {
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        agendamentoDAO.atualizar(agendamento);
    }

    // Deletar
    public void deletarBo(int idAgendamento) throws ClassNotFoundException, SQLException {
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        agendamentoDAO.deletar(idAgendamento);
    }
}
