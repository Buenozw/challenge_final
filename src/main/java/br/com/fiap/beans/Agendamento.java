package br.com.fiap.beans;

public class Agendamento {

    private String datahora;
    private String tipoAgendamento;
    private int idAgendamento;

    public Agendamento() {
    }

    public Agendamento(String datahora, String tipoAgendamento, int idAgendamento) {
        this.datahora = datahora;
        this.tipoAgendamento = tipoAgendamento;
        this.idAgendamento = idAgendamento;
    }

    public String getDatahora() {
        return datahora;
    }

    public void setDatahora(String datahora) {
        this.datahora = datahora;
    }

    public String getTipoExame() {
        return tipoAgendamento;
    }

    public void setTipoExame(String tipoExame) {
        this.tipoAgendamento = tipoExame;
    }

    public int getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(int idAgendamento) {
        this.idAgendamento = idAgendamento;
    }
}