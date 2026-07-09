package com.exemplo.excelgenerator.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DadosRelatorioResponse {
    
    private List<DadosPessoaResponse> dadosPessoa;
    private List<DadosRemuneracaoResponse> dadosRemuneracao;
    private List<DadosVinculoResponse> dadosVinculo;
    private List<DadosDependenteResponse> dadosDependente;
}
