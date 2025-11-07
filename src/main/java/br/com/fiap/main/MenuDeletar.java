package br.com.fiap.main;

import br.com.fiap.beans.Remedios;
import br.com.fiap.dao.*;

import javax.swing.*;
import java.sql.SQLException;

public class MenuDeletar {

    static int inteiro(String i) {
        return Integer.parseInt(JOptionPane.showInputDialog(i));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(
                    " >>>> MENU PARA DELETAR <<<< \n" +
                            "[1] - Deletar Paciente\n" +
                            "[2] - Deletar Agendamento\n" +
                            "[3] - Deletar Consulta\n" +
                            "[4] - Deletar Endereço\n" +
                            "[5] - Deletar Exame\n" +
                            "[6] - Deletar Login\n" +
                            "[7] - Deletar Remédio\n" +
                            "[0] - Sair"
            ));

            switch (opcao) {
                case 1 -> deletarPaciente();
                case 2 -> deletarAgendamento();
                case 3 -> deletarConsulta();
                case 4 -> deletarEndereco();
                case 5 -> deletarExame();
                case 6 -> deletarLogin();
                case 7 -> deletarRemedios();
                case 0 -> JOptionPane.showMessageDialog(null, "Encerrando...");
                default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
            }

        } while (opcao != 0);
    }

    // MÉTODOS DELETAR

    private static void deletarPaciente() throws SQLException, ClassNotFoundException {
        PacienteDAO dao = new PacienteDAO();
        int id = inteiro("Digite o ID do paciente a deletar: ");
        JOptionPane.showMessageDialog(null, dao.deletar(id));
    }

    private static void deletarAgendamento() throws SQLException, ClassNotFoundException {
        AgendamentoDAO dao = new AgendamentoDAO();
        int id = inteiro("Digite o ID do agendamento a deletar: ");
        JOptionPane.showMessageDialog(null, dao.deletar(id));
    }

    private static void deletarConsulta() throws SQLException, ClassNotFoundException {
        ConsultaDAO dao = new ConsultaDAO();
        int id = inteiro("Digite o ID da consulta a deletar: ");
        JOptionPane.showMessageDialog(null, dao.deletar(id));
    }

    private static void deletarEndereco() throws SQLException, ClassNotFoundException {
        EnderecoDAO dao = new EnderecoDAO();
        int id = inteiro("Digite o ID do endereço a deletar: ");
        JOptionPane.showMessageDialog(null, dao.deletar((id)));
    }

    private static void deletarExame() throws SQLException, ClassNotFoundException {
        ExameDAO dao = new ExameDAO();
        int id = inteiro("Digite o ID do exame a deletar: ");
        JOptionPane.showMessageDialog(null, dao.deletar(id));
    }

    private static void deletarLogin() throws SQLException, ClassNotFoundException {
        LoginDAO dao = new LoginDAO();
        int id = inteiro("Digite o ID do login a deletar: ");
        JOptionPane.showMessageDialog(null, dao.deletar(id));
    }

    private static void deletarRemedios() throws SQLException, ClassNotFoundException {
        RemediosDAO dao = new RemediosDAO();
        int id = inteiro("Digite o ID do Remédio para deletar: ");
        JOptionPane.showMessageDialog(null, dao.deletar(id));

    }
}