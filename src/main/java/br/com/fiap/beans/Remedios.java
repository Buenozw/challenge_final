package br.com.fiap.beans;

public class Remedios {
    private int id_remedio;
    private String nome_remedio;
    private String descricao_remedio;
    private double preco_remedio;
    private String quantidade_remedio;

    public Remedios() {

    }

    public Remedios(int id_remedio, String nome_remedio, String descricao_remedio, double preco_remedio, String quantidade_remedio) {
        this.id_remedio = id_remedio;
        this.nome_remedio = nome_remedio;
        this.descricao_remedio = descricao_remedio;
        this.preco_remedio = preco_remedio;
        this.quantidade_remedio = quantidade_remedio;
    }

    public int getId_remedio() {
        return id_remedio;
    }

    public void setId_remedio(int id_remedio) {
        this.id_remedio = id_remedio;
    }

    public String getNome_remedio() {
        return nome_remedio;
    }

    public void setNome_remedio(String nome_remedio) {
        this.nome_remedio = nome_remedio;
    }

    public String getDescricao_remedio() {
        return descricao_remedio;
    }

    public void setDescricao_remedio(String descricao_remedio) {
        this.descricao_remedio = descricao_remedio;
    }

    public double getPreco_remedio() {
        return preco_remedio;
    }

    public void setPreco_remedio(double preco_remedio) {
        this.preco_remedio = preco_remedio;
    }

    public String getQuantidade_remedio() {
        return quantidade_remedio;
    }

    public void setQuantidade_remedio(String quantidade_remedio) {
        this.quantidade_remedio = quantidade_remedio;
    }
}


