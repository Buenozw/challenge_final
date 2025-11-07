package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.RecuperacaoSenha;
import br.com.fiap.dao.RecuperacaoSenhaDAO;

public class RecuperacaoSenhaBO {

    RecuperacaoSenhaDAO recuperacaoSenhaDAO;

    // Selecionar
    public ArrayList<RecuperacaoSenha> selecionarBo() throws ClassNotFoundException, SQLException {
        recuperacaoSenhaDAO = new RecuperacaoSenhaDAO();
        return (ArrayList<RecuperacaoSenha>) recuperacaoSenhaDAO.selecionar();
    }

    // Inserir
    public void inserirBo(RecuperacaoSenha recuperacaoSenha) throws ClassNotFoundException, SQLException {
        RecuperacaoSenhaDAO recuperacaoSenhaDAO = new RecuperacaoSenhaDAO();
        recuperacaoSenhaDAO.inserir(recuperacaoSenha);
    }

    // Atualizar
    public void atualizarBo(RecuperacaoSenha recuperacaoSenha) throws ClassNotFoundException, SQLException {
        RecuperacaoSenhaDAO recuperacaoSenhaDAO = new RecuperacaoSenhaDAO();
        recuperacaoSenhaDAO.atualizar(recuperacaoSenha);
    }

    // Deletar
    public void deletarBo(int idRecuperacaoSenha) throws ClassNotFoundException, SQLException {
        RecuperacaoSenhaDAO recuperacaoSenhaDAO = new RecuperacaoSenhaDAO();
        recuperacaoSenhaDAO.deletar(idRecuperacaoSenha);
    }
}
