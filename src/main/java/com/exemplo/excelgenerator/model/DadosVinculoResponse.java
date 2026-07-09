package com.exemplo.excelgenerator.model;

public class DadosVinculoResponse {
    
    private String cpf;
    private String possuiVinculo;
    private String matricula;
    private String tipoRegimeTrabalhista;
    private String dataAdmissao;
    private String tipoContrato;
    private String dataTerminoContrato;
    private String motivoDesligamento;
    private String motivoTermino;


    public DadosVinculoResponse() {}

    // Getters e Setters
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getPossuiVinculo() { return possuiVinculo; }
    public void setPossuiVinculo(String possuiVinculo) { this.possuiVinculo = possuiVinculo; }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public String getTipoRegimeTrabalhista() { return tipoRegimeTrabalhista; }
    public void setTipoRegimeTrabalhista(String tipoRegimeTrabalhista) { this.tipoRegimeTrabalhista = tipoRegimeTrabalhista; }

    public String getDataAdmissao() { return dataAdmissao; }
    public void setDataAdmissao(String dataAdmissao) { this.dataAdmissao = dataAdmissao; }

    public String getTipoContrato() { return tipoContrato; }
    public void setTipoContrato(String tipoContrato) { this.tipoContrato = tipoContrato; }

    public String getDataTerminoContrato() { return dataTerminoContrato; }
    public void setDataTerminoContrato(String dataTerminoContrato) { this.dataTerminoContrato = dataTerminoContrato; }

    public String getMotivoDesligamento() { return motivoDesligamento; }
    public void setMotivoDesligamento(String motivoDesligamento) { this.motivoDesligamento = motivoDesligamento; }

    public String getMotivoTermino() { return motivoTermino; }
    public void setMotivoTermino(String motivoTermino) { this.motivoTermino = motivoTermino; }

}
