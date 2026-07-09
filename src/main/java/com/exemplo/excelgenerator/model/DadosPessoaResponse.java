package com.exemplo.excelgenerator.model;

public class DadosPessoaResponse {
    
    private String cpf;
    private String nome;
    private String dataNascimento;

    // Construtores
    public DadosPessoaResponse() {}

    // Getters e Setters
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }
}
