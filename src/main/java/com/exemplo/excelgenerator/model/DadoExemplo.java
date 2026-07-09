package com.exemplo.excelgenerator.model;

import java.time.LocalDate;

public class DadoExemplo {
    
    private String nome;
    private String cpf;
    private Double valor;
    private LocalDate data;

    // Construtores
    public DadoExemplo() {}

    public DadoExemplo(String nome, String cpf, Double valor, LocalDate data) {
        this.nome = nome;
        this.cpf = cpf;
        this.valor = valor;
        this.data = data;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
