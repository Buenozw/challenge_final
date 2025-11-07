package br.com.fiap.dao;

import br.com.fiap.beans.Paciente;
import br.com.fiap.beans.RecuperacaoSenha;
import br.com.fiap.conexao.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecuperacaoSenhaDAO {

    public Connection minhaConexao;

    public RecuperacaoSenhaDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(RecuperacaoSenha recuperacaoSenha) throws SQLException {
        PreparedStatement stmt = this.minhaConexao.prepareStatement("Insert into RECUPERACAOSENHA (USUARIO, NOVASENHA) values (?, ?)");
        stmt.setString(1, recuperacaoSenha.getUsuario());
        //stmt.setString(2, recuperacaoSenha.getSenha());
        stmt.setString(2, recuperacaoSenha.getNovaSenha());
        //stmt.setInt(4, recuperacaoSenha.getIdRecuperacaoSenha());

        stmt.execute();
        stmt.close();

        return "Recuperação de senha realizada com sucesso✅";
    }

    // Delete
    public String deletar(int idRecuperacaoSenha) throws SQLException {
        PreparedStatement stmt =
        minhaConexao.prepareStatement("Delete from RECUPERACAOSENHA where ID_RECUPERACAOSENHA = ?");
        stmt.setInt(1, idRecuperacaoSenha);

        stmt.execute();
        stmt.close();

        return "Recuperação de senha deletado com sucesso✅!";
    }

    // UpDate
    public String atualizar (RecuperacaoSenha recuperacaoSenha) throws SQLException {
        PreparedStatement stmt =
        minhaConexao.prepareStatement("Update RECUPERACAOSENHA set EMAIL = ?, SENHA = ?, NOVA_SENHA = ?, where ID_RECUPERACAOSENHA = ?");

        stmt.setString(1, recuperacaoSenha.getUsuario());
        stmt.setString(2, recuperacaoSenha.getSenha());
        stmt.setString(3, recuperacaoSenha.getNovaSenha());
        stmt.setInt(4, recuperacaoSenha.getIdRecuperacaoSenha());
        stmt.executeUpdate();
        stmt.close();

        return "Recuperação de senha atualizado com sucesso ✅!";
    }

    // Select
    public List<RecuperacaoSenha> selecionar() throws SQLException {
        ArrayList<RecuperacaoSenha> listRecupercaoSenha = new ArrayList<RecuperacaoSenha>();

        PreparedStatement stmt =
        minhaConexao.prepareStatement("select * from RECUPERACAO_SENHA");

        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            RecuperacaoSenha objRecuperacaoSenha = new RecuperacaoSenha();
            objRecuperacaoSenha.setUsuario(rs.getString("USUARIO"));
            objRecuperacaoSenha.setSenha(rs.getString("SENHA"));
            objRecuperacaoSenha.setNovaSenha(rs.getString("NOVA_SENHA"));
            objRecuperacaoSenha.setIdRecuperacaoSenha(rs.getInt("ID_RECUPERACAOSENHA"));
            listRecupercaoSenha.add(objRecuperacaoSenha);
        }
        return listRecupercaoSenha;
    }
}
