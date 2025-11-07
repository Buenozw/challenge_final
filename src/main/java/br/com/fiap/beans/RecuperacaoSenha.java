package br.com.fiap.beans;

public class RecuperacaoSenha extends Login {

    private String usuario;
    private String senha;
    private String novaSenha;
    private int idRecuperacaoSenha;

    public RecuperacaoSenha() {
    }

    public RecuperacaoSenha(String usuario, String senha, String novaSenha, int idRecuperacaoSenha) {
        this.usuario = usuario;
        this.senha = senha;
        this.novaSenha = novaSenha;
        this.idRecuperacaoSenha = idRecuperacaoSenha;
    }

    public String getEmail() {
        return usuario;
    }

    public void setEmail(String email) {
        this.usuario = email;
    }

    @Override
    public String getSenha() {
        return senha;
    }

    @Override
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }

    public int getIdRecuperacaoSenha() {
        return idRecuperacaoSenha;
    }

    public void setIdRecuperacaoSenha(int idRecuperacaoSenha) {
        this.idRecuperacaoSenha = idRecuperacaoSenha;
    }
}
