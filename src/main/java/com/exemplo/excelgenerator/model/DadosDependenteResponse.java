package com.exemplo.excelgenerator.model;

public class DadosDependenteResponse {
    
    private String cpfTrabalhador;
    private String nomeDependente;
    private String cpfDependente;
    private String tipoDependente;

    public DadosDependenteResponse() {}

    public String getCpfTrabalhador() { return cpfTrabalhador; }
    public void setCpfTrabalhador(String cpfTrabalhador) { this.cpfTrabalhador = cpfTrabalhador; }

    public String getNomeDependente() { return nomeDependente; }
    public void setNomeDependente(String nomeDependente) { this.nomeDependente = nomeDependente; }

    public String getCpfDependente() { return cpfDependente; }
    public void setCpfDependente(String cpfDependente) { this.cpfDependente = cpfDependente; }

    public String getTipoDependente() { return tipoDependente; }
    public void setTipoDependente(String tipoDependente) { this.tipoDependente = tipoDependente; }
}
