package br.com.fiap.beans;

public class Notificacao {

    private String mensagem;
    private String dataExame;
    private String horaExame;
    private String tipo;
    private int idNotificacao;

    public Notificacao() {
    }

    public Notificacao(String mensagem, String dataExame, String horaExame, String tipo, int idNotificacao) {
        this.mensagem = mensagem;
        this.dataExame = dataExame;
        this.horaExame = horaExame;
        this.tipo = tipo;
        this.idNotificacao = idNotificacao;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getDataExame() {
        return dataExame;
    }

    public void setDataExame(String dataExame) {
        this.dataExame = dataExame;
    }

    public String getHoraExame() {
        return horaExame;
    }

    public void setHoraExame(String horaExame) {
        this.horaExame = horaExame;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdNotificacao() {
        return idNotificacao;
    }

    public void setIdNotificacao(int idNotificacao) {
        this.idNotificacao = idNotificacao;
    }
}
