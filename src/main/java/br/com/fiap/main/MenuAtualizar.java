package br.com.fiap.main;

import br.com.fiap.beans.*;
import br.com.fiap.dao.*;

import javax.swing.*;
import java.sql.SQLException;

public class MenuAtualizar {

    static String texto(String t) {
        return JOptionPane.showInputDialog(t);
    }

    static int inteiro(String i) {
        return Integer.parseInt(JOptionPane.showInputDialog(i));
    }

    static double decimal(String d) {
        return Double.parseDouble(JOptionPane.showInputDialog(d));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(
                    " >>>> MENU PARA ATUALIZAR <<<< \n" +
                            "[1] - Atualizar Paciente\n" +
                            "[2] - Atualizar Agendamento\n" +
                            "[3] - Atualizar Consulta\n" +
                            "[4] - Atualizar Endereço\n" +
                            "[5] - Atualizar Exame\n" +
                            "[6] - Atualizar Login\n" +
                            "[7] - Atualizar Recuperação de Senha\n" +
                            "[8] - Atualizar Remedios\n" +
                            "[0] - Sair"
            ));

            switch (opcao) {
                case 1 -> atualizarPaciente();
                case 2 -> atualizarAgendamento();
                case 3 -> atualizarConsulta();
                case 4 -> atualizarEndereco();
                case 5 -> atualizarExame();
                case 6 -> atualizarLogin();
                case 7 -> atualizarRecuperacaoSenha();
                case 8 -> atualizarRemedios();
                case 0 -> JOptionPane.showMessageDialog(null, "Encerrando...");
                default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
            }

        } while (opcao != 0);
    }


    // MÉTODOS DE ATUALIZAÇÃO

    private static void atualizarPaciente() throws SQLException, ClassNotFoundException {
        PacienteDAO dao = new PacienteDAO();
        Paciente obj = new Paciente();

        obj.setIdPaciente(inteiro("Digite o ID do paciente a atualizar: "));
        obj.setNome(texto("Novo nome: "));
        obj.setIdade(inteiro("Nova idade: "));
        obj.setSexo(texto("Novo sexo: "));

        JOptionPane.showMessageDialog(null, dao.atualizar(obj));
    }

    private static void atualizarAgendamento() throws SQLException, ClassNotFoundException {
        AgendamentoDAO dao = new AgendamentoDAO();
        Agendamento obj = new Agendamento();

        obj.setIdAgendamento(inteiro("Digite o ID do agendamento a atualizar: "));
        obj.setDatahora(texto("Nova data (dd/mm/aaaa): "));
        obj.setTipoExame(texto("Novo tipo de exame: "));

        JOptionPane.showMessageDialog(null, dao.atualizar(obj));
    }

    private static void atualizarConsulta() throws SQLException, ClassNotFoundException {
        ConsultaDAO dao = new ConsultaDAO();
        Consulta obj = new Consulta();

        obj.setId_consulta(inteiro("Digite o ID da consulta a atualizar: "));
        obj.setDatahora_consulta(texto("Nova data e hora (dd/mm/aaaa hh:mm) da consulta: "));

        JOptionPane.showMessageDialog(null, dao.atualizar(obj));
    }

    private static void atualizarEndereco() throws SQLException, ClassNotFoundException {
        EnderecoDAO dao = new EnderecoDAO();
        Endereco obj = new Endereco();

        obj.setRua(texto("Nova rua: "));
        obj.setNumero(inteiro("Novo número: "));
        obj.setCep(inteiro("Digite o novo CEP: "));

        JOptionPane.showMessageDialog(null, dao.atualizar(obj));
    }

    private static void atualizarExame() throws SQLException, ClassNotFoundException {
        ExameDAO dao = new ExameDAO();
        Exame obj = new Exame();

        obj.setIdExame(inteiro("Digite o ID do exame a atualizar: "));
        obj.setTipoExame(texto("Novo tipo de exame: "));
        obj.setData(texto("Nova data (dd/mm/aaaa): "));
        obj.setLocal(texto("Novo local: "));

        JOptionPane.showMessageDialog(null, dao.atualizar(obj));
    }

    private static void atualizarLogin() throws SQLException, ClassNotFoundException {
        LoginDAO dao = new LoginDAO();
        Login obj = new Login();

        obj.setIdLogin(inteiro("Digite o ID do login a atualizar: "));
        obj.setUsuario(texto("Novo usuário: "));
        obj.setSenha(texto("Nova senha: "));

        JOptionPane.showMessageDialog(null, dao.atualizar(obj));
    }

    private static void atualizarRecuperacaoSenha() throws SQLException, ClassNotFoundException {
        RecuperacaoSenhaDAO dao = new RecuperacaoSenhaDAO();
        RecuperacaoSenha obj = new RecuperacaoSenha();

        obj.setEmail(texto("Novo usuario: "));
        obj.setNovaSenha(texto("Nova senha: "));

        JOptionPane.showMessageDialog(null, dao.atualizar(obj));
    }

    private static void atualizarRemedios() throws SQLException, ClassNotFoundException {
        RemediosDAO dao = new RemediosDAO();
        Remedios obj = new Remedios();

        obj.setNome_remedio(texto("Novo nome: "));
        obj.setDescricao_remedio(texto("Nova descrição: "));
        obj.setPreco_remedio(decimal("Digite o novo preço: "));
        obj.setQuantidade_remedio(texto("Digite a nova quantidade: "));

        JOptionPane.showMessageDialog(null, dao.atualizar(obj));
    }


}
