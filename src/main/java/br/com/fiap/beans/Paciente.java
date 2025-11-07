package br.com.fiap.beans;

public class Paciente {

    private int idPaciente;
    private String nome;
    private int idade;
    private String cpf;
    private String sexo;

    // Metodos Contrutores
    public Paciente() {
    }

    public Paciente(int idPaciente, String nome, int idade, String cpf, String sexo) {
        this.idPaciente = idPaciente;
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.sexo = sexo;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}