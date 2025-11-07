package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Login;
import br.com.fiap.dao.LoginDAO;

public class LoginBO {

    LoginDAO loginDAO;

    // Selecionar
    public ArrayList<Login> selecionarBo() throws ClassNotFoundException, SQLException {
        loginDAO = new LoginDAO();
        return (ArrayList<Login>) loginDAO.selecionar();
    }

    // Inserir
    public void inserirBo(Login login) throws ClassNotFoundException, SQLException {
        LoginDAO loginDAO = new LoginDAO();
        loginDAO.inserir(login);
    }

    // Atualizar
    public void atualizarBo(Login login) throws ClassNotFoundException, SQLException {
        LoginDAO loginDAO = new LoginDAO();
        loginDAO.atualizar(login);
    }

    // Deletar
    public void deletarBo(int idLogin) throws ClassNotFoundException, SQLException {
        LoginDAO loginDAO = new LoginDAO();
        loginDAO.deletar(idLogin);
    }
}
