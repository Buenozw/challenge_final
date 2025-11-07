package br.com.fiap.beans;

public class Consulta {

    private int id_consulta;
    private String datahora_consulta;
    private String descricao_consulta;
    private String nome_consulta;

    // Metodos contrutores
    public Consulta() {
    }

    public Consulta(int id_consulta, String datahora_consulta, String descricao_consulta, String nome_consulta) {
        this.id_consulta = id_consulta;
        this.datahora_consulta = datahora_consulta;
        this.descricao_consulta = descricao_consulta;
        this.nome_consulta = nome_consulta;
    }

    public int getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(int id_consulta) {
        this.id_consulta = id_consulta;
    }

    public String getDatahora_consulta() {
        return datahora_consulta;
    }

    public void setDatahora_consulta(String datahora_consulta) {
        this.datahora_consulta = datahora_consulta;
    }

    public String getDescricao_consulta() {
        return descricao_consulta;
    }

    public void setDescricao_consulta(String descricao_consulta) {
        this.descricao_consulta = descricao_consulta;
    }

    public String getNome_consulta() {
        return nome_consulta;
    }

    public void setNome_consulta(String nome_consulta) {
        this.nome_consulta = nome_consulta;
    }
}

