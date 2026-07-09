package com.exemplo.excelgenerator.model;

import java.util.List;

public class RelatorioRequest {
    
    private String titulo;
    private List<DadoExemplo> dados;

    // Construtores
    public RelatorioRequest() {}

    public RelatorioRequest(String titulo, List<DadoExemplo> dados) {
        this.titulo = titulo;
        this.dados = dados;
    }

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<DadoExemplo> getDados() {
        return dados;
    }

    public void setDados(List<DadoExemplo> dados) {
        this.dados = dados;
    }
}
