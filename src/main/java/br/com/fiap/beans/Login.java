package br.com.fiap.beans;

public class Login {

    private String usuario;
    private String senha;
    private int idLogin;

    public Login() {
    }

    public Login(String usuario, String senha, int idLogin, String novasenha) {
        this.usuario = usuario;
        this.senha = senha;
        this.idLogin = idLogin;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }
}
