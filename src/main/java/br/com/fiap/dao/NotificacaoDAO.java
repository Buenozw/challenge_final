package br.com.fiap.dao;

import br.com.fiap.beans.Notificacao;
import br.com.fiap.conexao.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NotificacaoDAO {

    public Connection minhaConexao;

    public NotificacaoDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(Notificacao notificacao) throws SQLException {
        PreparedStatement stmt =
        minhaConexao.prepareStatement("Insert int NOTIFICACAO (MENSAGEM, DATAEXAME, HORAEXAME, TIPO) value (?, ?, ?, ?)");
        stmt.setString(1, notificacao.getMensagem());
        stmt.setString(2, notificacao.getDataExame());
        stmt.setString(3, notificacao.getHoraExame());
        stmt.setString(4, notificacao.getTipo());
        stmt.setInt(5, notificacao.getIdNotificacao());

        stmt.execute();
        stmt.close();

        return "Notificação cadastrado com sucesso✅";
    }

    // Delete
    public String deletar(int idNotificacao) throws SQLException {
        PreparedStatement stmt =
        minhaConexao.prepareStatement("Delete from NOTIFICACAO where ID_NOTIFICACAO = ?");
        stmt.setInt(1, idNotificacao);

        stmt.execute();
        stmt.close();

        return "Notificação deletado com sucesso✅!";
    }

    // UpDate
    public String atualizar (Notificacao notificacao) throws SQLException {
        PreparedStatement stmt =
        minhaConexao.prepareStatement("Update NOTIFICACAO set MENSAGEM = ?, DATA_EXAME = TO_DATE(?, 'DD/MM/YYYY HH24:MI'), HORA_EXAME = ?, TIPO = ? where ID_NOTIFICACAO = ?");

        stmt.setString(1, notificacao.getMensagem());
        stmt.setString(2, notificacao.getDataExame());
        stmt.setString(3, notificacao.getHoraExame());
        stmt.setString(4, notificacao.getTipo());
        stmt.setInt(5, notificacao.getIdNotificacao());
        stmt.executeUpdate();
        stmt.close();

        return "Notificações atualizado com sucesso ✅!";
    }

    // Select
    public List<Notificacao> selecionar() throws SQLException {
        ArrayList<Notificacao> listNotificacao = new ArrayList<Notificacao>();

        PreparedStatement stmt =
        minhaConexao.prepareStatement("select * from NOTIFICACAO");

        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            Notificacao objNotificacao = new Notificacao();
            objNotificacao.setMensagem(rs.getString("MENSAGEM"));
            objNotificacao.setDataExame(rs.getString("DATA_EXAME"));
            objNotificacao.setHoraExame(rs.getString("HORA_EXAME"));
            objNotificacao.setTipo(rs.getString("TIPO"));
            objNotificacao.setIdNotificacao(rs.getInt("ID_NOTIFICACAO"));
            listNotificacao.add(objNotificacao);
        }
        return listNotificacao;
    }
}
