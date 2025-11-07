package br.com.fiap.main;

import br.com.fiap.beans.*;
import br.com.fiap.dao.*;

import javax.swing.*;
import java.sql.SQLException;

public class MenuInserir {

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
                    " >>>> MENU DE INSERÇÃO <<<< \n" +
                            "[1] - Inserir Paciente\n" +
                            "[2] - Inserir Agendamento\n" +
                            "[3] - Inserir Consulta\n" +
                            "[4] - Inserir Endereço\n" +
                            "[5] - Inserir Exame\n" +
                            "[6] - Inserir Login\n" +
                            "[7] - Inserir Recuperação de Senha\n" +
                            "[8] - Inserir Remédios\n" +
                            "[0] - Sair"
            ));

            switch (opcao) {
                case 1 -> inserirPaciente();
                case 2 -> inserirAgendamento();
                case 3 -> inserirConsulta();
                case 4 -> inserirEndereco();
                case 5 -> inserirExame();
                case 6 -> inserirLogin();
                case 7 -> inserirRecuperacaoSenha();
                case 8 -> inserirRemedios();
                case 0 -> JOptionPane.showMessageDialog(null, "Encerrando o sistema...");
                default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
            }

        } while (opcao != 0);
    }

    // MÉTODOS DE INSERÇÃO

    private static void inserirPaciente() throws SQLException, ClassNotFoundException {
        PacienteDAO dao = new PacienteDAO();
        Paciente obj = new Paciente();

        obj.setNome(texto("Digite o nome do paciente: "));
        obj.setIdade(inteiro("Informe a idade do paciente: "));
        obj.setCpf(texto("Informe o CPF (000-000-000-00) do paciente: "));
        obj.setSexo(texto("Digite o sexo do paciente: "));

        JOptionPane.showMessageDialog(null, dao.inserir(obj));
    }

    private static void inserirAgendamento() throws SQLException, ClassNotFoundException {
        AgendamentoDAO dao = new AgendamentoDAO();
        Agendamento obj = new Agendamento();

        obj.setDatahora(texto("Data do exame (dd/mm/aaaa) (hh:mm): "));
        obj.setTipoExame(texto("Informe o tipo do agendamento (consulta ou exame): "));

        JOptionPane.showMessageDialog(null, dao.inserir(obj));
    }

    private static void inserirConsulta() throws SQLException, ClassNotFoundException {
        ConsultaDAO dao = new ConsultaDAO();
        Consulta obj = new Consulta();

        obj.setNome_consulta(texto("Digite a data e hora(dd/mm/aaaa hh:mm) da consulta: "));
        obj.setDescricao_consulta(texto("Digite a descrição: "));
        obj.setNome_consulta(texto("Digite o nome da consulta: "));

        JOptionPane.showMessageDialog(null, dao.inserir(obj));
    }

    private static void inserirEndereco() throws SQLException, ClassNotFoundException {
        EnderecoDAO dao = new EnderecoDAO();
        Endereco obj = new Endereco();

        obj.setRua(texto("Endereço: "));
        obj.setNumero(inteiro("Número do endereço: "));
        obj.setCep(inteiro("CEP do endereço: "));

        JOptionPane.showMessageDialog(null, dao.inserir(obj));
    }

    private static void inserirExame() throws SQLException, ClassNotFoundException {
        ExameDAO dao = new ExameDAO();
        Exame obj = new Exame();

        obj.setTipoExame(texto("Informe o tipo do exame: "));
        obj.setData(texto("Data e hora do exame (dd/mm/aaaa hh:mm): "));
        obj.setLocal(texto("Informe Local do exame: "));

        JOptionPane.showMessageDialog(null, dao.inserir(obj));
    }

    private static void inserirLogin() throws SQLException, ClassNotFoundException {
        LoginDAO dao = new LoginDAO();
        Login obj = new Login();

        obj.setUsuario(texto("Digite o usuário: "));
        obj.setSenha(texto("Digite a senha(somente texto): "));

        JOptionPane.showMessageDialog(null, dao.inserir(obj));
    }

    private static void inserirRecuperacaoSenha() throws SQLException, ClassNotFoundException {
        RecuperacaoSenhaDAO dao = new RecuperacaoSenhaDAO();
        RecuperacaoSenha obj = new RecuperacaoSenha();

        obj.setEmail(texto("Digite o usuário: "));
        obj.setNovaSenha(texto("Digite a nova senha(somente texto): "));

        JOptionPane.showMessageDialog(null, dao.inserir(obj));
    }

    private static void inserirRemedios() throws SQLException, ClassNotFoundException {
        RemediosDAO dao = new RemediosDAO();
        Remedios obj = new Remedios();

        obj.setNome_remedio(texto("Digite o nome do remédio: "));
        obj.setDescricao_remedio(texto("Digite uma possivel descrição: "));
        obj.setPreco_remedio(decimal("Digite o preço do remédio: "));
        obj.setQuantidade_remedio(texto("Digite quantidade: "));

        JOptionPane.showMessageDialog(null, dao.inserir(obj));
    }


}
