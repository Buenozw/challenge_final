package br.com.fiap.dao;

import br.com.fiap.beans.Paciente;
import br.com.fiap.conexao.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {

    public Connection minhaConexao;

    public PacienteDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(Paciente paciente) throws SQLException {
        PreparedStatement stmt =
        minhaConexao.prepareStatement("Insert into PACIENTE (NOME, IDADE, CPF, SEXO) values (?, ?, ?, ?)");

        stmt.setString(1, paciente.getNome());
        stmt.setInt(2, paciente.getIdade());
        stmt.setString(3, paciente.getCpf());
        stmt.setString(4, paciente.getSexo());

        stmt.execute();
        stmt.close();

        return "Paciente cadastrado com sucesso";
    }

    // Delete
    public String deletar(int idPaciente) throws SQLException {
        PreparedStatement stmt =
        minhaConexao.prepareStatement("Delete from PACIENTE where ID_PACIENTE = ?");
        stmt.setInt(1, idPaciente);

        stmt.execute();
        stmt.close();

        return "Paciente deletado com sucesso ✅!";
    }

    // UpDate
    public String atualizar(Paciente paciente) throws SQLException {
        PreparedStatement stmt =
        minhaConexao.prepareStatement("Update PACIENTE set NOME = ?, IDADE = ?, SEXO = ? where ID_PACIENTE = ?");

        stmt.setString(1, paciente.getNome());
        stmt.setInt(2, paciente.getIdade());
        stmt.setString(3, paciente.getSexo());
        stmt.setInt(4, paciente.getIdPaciente());

        stmt.executeUpdate();
        stmt.close();

        return "Paciente atualizado com sucesso✅!";
    }

    // Select
    public List<Paciente> selecionar() throws SQLException {
        List<Paciente> listPaciente = new ArrayList<>();

        PreparedStatement stmt =
                minhaConexao.prepareStatement("SELECT * FROM PACIENTE"); // sem parâmetros
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            Paciente objPaciente = new Paciente();
            objPaciente.setIdPaciente(rs.getInt("ID_PACIENTE"));
            objPaciente.setNome(rs.getString("NOME"));
            objPaciente.setIdade(rs.getInt("IDADE"));
            objPaciente.setCpf(rs.getString("CPF"));
            objPaciente.setSexo(rs.getString("SEXO"));
            listPaciente.add(objPaciente);
        }

        rs.close();
        stmt.close();
        return listPaciente;
    }

}

