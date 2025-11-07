package br.com.fiap.beans;

public class Medico {

    private String nomeMedico;
    private String crm;
    private String especialidade;

    public Medico() {
    }

    public Medico(String nomeMedico, String crm, String especialidade) {
        this.nomeMedico = nomeMedico;
        this.crm = crm;
        this.especialidade = especialidade;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
