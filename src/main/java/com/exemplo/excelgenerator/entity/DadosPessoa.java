package com.exemplo.excelgenerator.entity;

import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
@Table(name = "dados_pessoa")
public class DadosPessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String cpf;
    private String nome;
    private String dataNascimento;

}
