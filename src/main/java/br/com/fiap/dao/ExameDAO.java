package br.com.fiap.dao;

import br.com.fiap.beans.Exame;
import br.com.fiap.conexao.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExameDAO {

    public Connection minhaConexao;

    public ExameDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao  = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(Exame exame) throws SQLException {
        PreparedStatement stmt =
        minhaConexao.prepareStatement("Insert into EXAME (TIPOEXAME ,DATA, LOCAL) values (?, TO_DATE(?, 'dd/mm/yyyy hh24:mi'), ?)");
        stmt.setString(1, exame.getTipoExame());
        stmt.setString(2, exame.getData());
        stmt.setString(3, exame.getLocal());

        stmt.execute();
        stmt.close();

        return "Exame cadastrado com sucesso ✅";
    }

    // Delete
    public String deletar(int idExame) throws SQLException {
        PreparedStatement stmt =
        minhaConexao.prepareStatement("Delete from EXAME where ID_EXAME = ?");
        stmt.setInt(1, idExame);

        stmt.execute();
        stmt.close();

        return "Exame deletado com sucesso ✅!";
    }

    // UpDate
    public String atualizar (Exame exame) throws SQLException {
        PreparedStatement stmt = this.minhaConexao.prepareStatement("Update EXAME set TIPOEXAME = ?, DATA = TO_DATE(?, 'DD/MM/YYYY HH24:MI'), LOCAL = ? where ID_EXAME = ?");

        stmt.setString(1, exame.getTipoExame());
        stmt.setString(2, exame.getData());
        stmt.setString(3, exame.getLocal());
        stmt.setInt(4, exame.getIdExame());

        stmt.executeUpdate();
        stmt.close();

        return "Exame atualizado com sucesso ✅!";
    }

    // Select
    public List<Exame> selecionar() throws SQLException {
        ArrayList<Exame> listExame = new ArrayList<Exame>();

        PreparedStatement stmt = this.minhaConexao.prepareStatement("select * from EXAME");
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            Exame objExame = new Exame();
            objExame.setTipoExame(rs.getString("TIPOEXAME"));
            objExame.setData(rs.getString("DATA"));
            objExame.setLocal(rs.getString("LOCAL"));
            objExame.setIdExame(rs.getInt("ID_EXAME"));
            listExame.add(objExame);
        }
        return listExame;
    }
}
