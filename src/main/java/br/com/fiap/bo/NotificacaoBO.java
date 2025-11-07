package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Notificacao;
import br.com.fiap.dao.NotificacaoDAO;

public class NotificacaoBO {

    NotificacaoDAO notificacaoDAO;

    // Selecionar
    public ArrayList<Notificacao> selecionarBo() throws ClassNotFoundException, SQLException {
        notificacaoDAO = new NotificacaoDAO();
        return (ArrayList<Notificacao>) notificacaoDAO.selecionar();
    }

    // Inserir
    public void inserirBo(Notificacao notificacao) throws ClassNotFoundException, SQLException {
        NotificacaoDAO notificacaoDAO = new NotificacaoDAO();
        notificacaoDAO.inserir(notificacao);
    }

    // Atualizar
    public void atualizarBo(Notificacao notificacao) throws ClassNotFoundException, SQLException {
        NotificacaoDAO notificacaoDAO = new NotificacaoDAO();
        notificacaoDAO.atualizar(notificacao);
    }

    // Deletar
    public void deletarBo(int idNotificacao) throws ClassNotFoundException, SQLException {
        NotificacaoDAO notificacaoDAO = new NotificacaoDAO();
        notificacaoDAO.deletar(idNotificacao);
    }
}
