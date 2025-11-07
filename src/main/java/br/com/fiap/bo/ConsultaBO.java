package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Consulta;
import br.com.fiap.dao.ConsultaDAO;

public class ConsultaBO {

    ConsultaDAO consultaDAO;

    // Selecionar
    public ArrayList<Consulta> selecionarBo() throws ClassNotFoundException, SQLException {
        consultaDAO = new ConsultaDAO();
        return (ArrayList<Consulta>) consultaDAO.selecionar();
    }

    // Inserir
    public void inserirBo(Consulta consulta) throws ClassNotFoundException, SQLException {
        ConsultaDAO consultaDAO = new ConsultaDAO();
        consultaDAO.inserir(consulta);
    }

    // Atualizar
    public void atualizarBo(Consulta consulta) throws ClassNotFoundException, SQLException {
        ConsultaDAO consultaDAO = new ConsultaDAO();
        consultaDAO.atualizar(consulta);
    }

    // Deletar
    public void deletarBo(int id_consulta) throws ClassNotFoundException, SQLException {
        ConsultaDAO consultaDAO = new ConsultaDAO();
        consultaDAO.deletar(id_consulta);
    }
}
