package br.com.fiap.beans;

public class Exame {

    private String tipoExame;
    private String data;
    private String local;
    private int idExame;

    public Exame() {
    }

    public Exame(String tipoExame, String data, String local, int idExame) {
        this.tipoExame = tipoExame;
        this.data = data;
        this.local = local;
        this.idExame = idExame;
    }

    public String getTipoExame() {
        return tipoExame;
    }

    public void setTipoExame(String tipoExame) {
        this.tipoExame = tipoExame;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getIdExame() {
        return  idExame;
    }

    public void setIdExame(int idExame) {
        this.idExame = idExame;
    }
}
