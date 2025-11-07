package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Paciente;
import br.com.fiap.dao.PacienteDAO;

public class PacienteBO {

    PacienteDAO pacienteDAO;

    // Selecionar
    public ArrayList<Paciente> selecionarBo() throws ClassNotFoundException, SQLException {
        pacienteDAO = new PacienteDAO();
        return (ArrayList<Paciente>) pacienteDAO.selecionar();
    }

    // Inserir
    public void inserirBo(Paciente paciente) throws ClassNotFoundException, SQLException {
        PacienteDAO pacienteDAO = new PacienteDAO();
        pacienteDAO.inserir(paciente);
    }

    // Atualizar
    public void atualizarBo(Paciente paciente) throws ClassNotFoundException, SQLException {
        PacienteDAO pacienteDAO = new PacienteDAO();
        pacienteDAO.atualizar(paciente);
    }

    // Deletar
    public void deletarBo(int idPaciente) throws ClassNotFoundException, SQLException {
        PacienteDAO pacienteDAO = new PacienteDAO();
        pacienteDAO.deletar(idPaciente);
    }
}
