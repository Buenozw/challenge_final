package br.com.fiap.main;

import br.com.fiap.beans.*;
import br.com.fiap.dao.*;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class MenuSelecionar {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(
                    " >>>> MENU PARA LISTAR <<<< \n" +
                            "[1] - Listar Pacientes\n" +
                            "[2] - Listar Agendamentos\n" +
                            "[3] - Listar Consultas\n" +
                            "[4] - Listar Endereços\n" +
                            "[5] - Listar Exames\n" +
                            "[6] - Listar Logins\n" +
                            "[7] - Listar Recuperações de Senha\n" +
                            "[8] - Listar Remedios\n" +
                            "[0] - Sair"
            ));

            switch (opcao) {
                case 1 -> listarPacientes();
                case 2 -> listarAgendamentos();
                case 3 -> listarConsultas();
                case 4 -> listarEnderecos();
                case 5 -> listarExames();
                case 6 -> listarLogins();
                case 7 -> listarRecuperacoes();
                case 8 -> listarRemedios();
                case 0 -> JOptionPane.showMessageDialog(null, "Encerrando...");
                default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
            }

        } while (opcao != 0);
    }

    // MÉTODOS DE LISTAGEM

    private static void listarPacientes() throws SQLException, ClassNotFoundException {
        PacienteDAO dao = new PacienteDAO();
        List<Paciente> lista = dao.selecionar();
        StringBuilder sb = new StringBuilder(" PACIENTES \n");
        for (Paciente p : lista) {
            sb.append("ID: ").append(p.getIdPaciente())
                    .append("Nome: ").append(p.getNome())
                    .append("Idade: ").append(p.getIdade())
                    .append("CPF: ").append(p.getCpf())
                    .append("Sexo: ").append(p.getSexo()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void listarAgendamentos() throws SQLException, ClassNotFoundException {
        AgendamentoDAO dao = new AgendamentoDAO();
        List<Agendamento> lista = dao.selecionar();
        StringBuilder sb = new StringBuilder(" AGENDAMENTOS \n");
        for (Agendamento a : lista) {
            sb.append("ID: ").append(a.getIdAgendamento())
                    .append("Data: ").append(a.getDatahora())
                    .append("Tipo: ").append(a.getTipoExame()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void listarConsultas() throws SQLException, ClassNotFoundException {
        ConsultaDAO dao = new ConsultaDAO();
        List<Consulta> lista = dao.selecionar();
        StringBuilder sb = new StringBuilder(" CONSULTAS \n");
        for (Consulta c : lista) {
            sb.append("ID: ").append(c.getId_consulta())
                    .append(" | Data/Hora: ").append(c.getDatahora_consulta()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void listarEnderecos() throws SQLException, ClassNotFoundException {
        EnderecoDAO dao = new EnderecoDAO();
        List<Endereco> lista = dao.selecionar();
        StringBuilder sb = new StringBuilder(" ENDEREÇOS \n");
        for (Endereco e : lista) {
            sb.append("Rua: ").append(e.getRua())
                    .append("Nº: ").append(e.getNumero())
                    .append("CEP: ").append(e.getCep()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void listarExames() throws SQLException, ClassNotFoundException {
        ExameDAO dao = new ExameDAO();
        List<Exame> lista = dao.selecionar();
        StringBuilder sb = new StringBuilder(" EXAMES \n");
        for (Exame ex : lista) {
            sb.append("ID: ").append(ex.getIdExame())
                    .append("Tipo: ").append(ex.getTipoExame())
                    .append("Data: ").append(ex.getData())
                    .append("Local: ").append(ex.getLocal()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void listarLogins() throws SQLException, ClassNotFoundException {
        LoginDAO dao = new LoginDAO();
        List<Login> lista = dao.selecionar();
        StringBuilder sb = new StringBuilder(" LOGINS \n");
        for (Login l : lista) {
            sb.append("ID: ").append(l.getIdLogin())
                    .append("Usuário: ").append(l.getUsuario())
                    .append("Senha: ").append(l.getSenha()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void listarRecuperacoes() throws SQLException, ClassNotFoundException {
        RecuperacaoSenhaDAO dao = new RecuperacaoSenhaDAO();
        List<RecuperacaoSenha> lista = dao.selecionar();
        StringBuilder sb = new StringBuilder(" RECUPERAÇÕES DE SENHA \n");
        for (RecuperacaoSenha r : lista) {
            sb.append("ID: ")
            .append("Email: ").append(r.getEmail())
            .append("Nova Senha: ").append(r.getNovaSenha()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void listarRemedios() throws SQLException, ClassNotFoundException {
        RemediosDAO dao = new RemediosDAO();
        List<Remedios> lista = dao.selecionar();
        StringBuilder sb = new StringBuilder(" REMEDIOS \n");
        for (Remedios l : lista) {
            sb.append("ID: ").append(l.getId_remedio())
                    .append("NOME: ").append(l.getNome_remedio())
                    .append("DESCRIÇÃO: ").append(l.getDescricao_remedio())
                    .append("PRECO: ").append(l.getPreco_remedio())
                    .append("QUANTIDADE: ").append(l.getQuantidade_remedio())
                    .append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
