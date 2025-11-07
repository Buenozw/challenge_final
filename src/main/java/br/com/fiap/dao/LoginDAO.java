package br.com.fiap.dao;

import br.com.fiap.beans.Login;
import br.com.fiap.conexao.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginDAO {

    public Connection minhaConexao;

    public LoginDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao  = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(Login login) throws SQLException {
        PreparedStatement stmt =
        minhaConexao.prepareStatement("Insert into LOGIN (USUARIO, SENHA) values (?, ?)");
        stmt.setString(1, login.getUsuario());
        stmt.setString(2, login.getSenha());
        //stmt.setInt(3, login.getIdLogin());

        stmt.execute();
        stmt.close();

        return "Login cadastrado com sucesso ✅";
    }

    // Delete
    public String deletar(int idLogin) throws SQLException {
        PreparedStatement stmt =
        minhaConexao.prepareStatement("Delete from LOGIN where ID_LOGIN = ?");
        stmt.setInt(1, idLogin);

        stmt.execute();
        stmt.close();

        return "Login deletado com sucesso ✅!";
    }

    // UpDate
    public String atualizar (Login login) throws SQLException {
        PreparedStatement stmt =
        minhaConexao.prepareStatement("Update LOGIN set USUARIO = ?, SENHA = ? where ID_LOGIN = ?");

        stmt.setString(1, login.getUsuario());
        stmt.setString(2, login.getSenha());
        stmt.setInt(3, login.getIdLogin());

        stmt.executeUpdate();
        stmt.close();

        return "Login atualizado com sucesso ✅!";
    }

    // Select
    public List<Login> selecionar() throws SQLException {
        ArrayList<Login> listLogin = new ArrayList<Login>();

        PreparedStatement stmt =
        minhaConexao.prepareStatement("select * from LOGIN");

        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            Login objLogin = new Login();

            objLogin.setUsuario(rs.getString("USUARIO"));
            objLogin.setSenha(rs.getString("SENHA"));
            objLogin.setIdLogin(rs.getInt("ID_LOGIN"));
            listLogin.add(objLogin);
        }
        return listLogin;
    }
}
