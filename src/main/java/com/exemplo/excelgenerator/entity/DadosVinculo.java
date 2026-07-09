package com.exemplo.excelgenerator.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "dados_vinculo")
public class DadosVinculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cpf;

    private String possuiVinculo;
    private String matricula;
    private String tipoRegimeTrabalhista;
    private String dataAdmissao;
    private String tipoContrato;
    private String dataTerminoContrato;
    private String motivoDesligamento;
    private String motivoTermino;
}
