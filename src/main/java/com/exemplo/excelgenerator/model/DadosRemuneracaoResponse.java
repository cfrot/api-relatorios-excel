package com.exemplo.excelgenerator.model;

public class DadosRemuneracaoResponse {
    
    private String cpf;
    private String matricula;
    private String salarioBase;
    private String unidadePagto;
    private String grauExposicao;
    private String dataInicio;

    public DadosRemuneracaoResponse() {}

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public String getSalarioBase() { return salarioBase; }
    public void setSalarioBase(String salarioBase) { this.salarioBase = salarioBase; }

    public String getUnidadePagto() { return unidadePagto; }
    public void setUnidadePagto(String unidadePagto) { this.unidadePagto = unidadePagto; }

    public String getGrauExposicao() { return grauExposicao; }
    public void setGrauExposicao(String grauExposicao) { this.grauExposicao = grauExposicao; }

    public String getDataInicio() { return dataInicio; }
    public void setDataInicio(String dataInicio) { this.dataInicio = dataInicio; }
}
