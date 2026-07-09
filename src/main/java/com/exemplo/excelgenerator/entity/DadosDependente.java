package com.exemplo.excelgenerator.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "dados_dependente")
public class DadosDependente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String cpfTrabalhador;
    private String nomeDependente;
    private String cpfDependente;
    private String tipoDependente;
}
