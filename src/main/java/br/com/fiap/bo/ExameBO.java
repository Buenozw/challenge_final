package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Exame;
import br.com.fiap.dao.ExameDAO;

public class ExameBO {

    ExameDAO exameDAO;

    // Selecionar
    public ArrayList<Exame> selecionarBo() throws ClassNotFoundException, SQLException {
        exameDAO = new ExameDAO();
        return (ArrayList<Exame>) exameDAO.selecionar();
    }

    // Inserir
    public void inserirBo(Exame exame) throws ClassNotFoundException, SQLException {
        ExameDAO exameDAO = new ExameDAO();
        exameDAO.inserir(exame);
    }

    // Atualizar
    public void atualizarBo(Exame exame) throws ClassNotFoundException, SQLException {
        ExameDAO exameDAO = new ExameDAO();
        exameDAO.atualizar(exame);
    }

    // Deletar
    public void deletarBo(int idExame) throws ClassNotFoundException, SQLException {
        ExameDAO exameDAO = new ExameDAO();
        exameDAO.deletar(idExame);
    }
}
