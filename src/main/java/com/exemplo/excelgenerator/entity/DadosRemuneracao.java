package com.exemplo.excelgenerator.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "dados_remuneracao")
public class DadosRemuneracao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String cpf;
    private String matricula;
    private String salarioBase;
    private String unidadePagto;
    private String grauExposicao;
    private String dataInicio;
}
