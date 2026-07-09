package com.exemplo.excelgenerator.repository;

import com.exemplo.excelgenerator.entity.DadosDependente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository para dados de dependentes.
 */
@Repository
public interface DadosDependenteRepository extends JpaRepository<DadosDependente, Long> {
    
    @Query(value = "SELECT * FROM dados_dependente WHERE cpf_trabalhador = :cpf", nativeQuery = true)
    List<DadosDependente> findByCpf(@Param("cpf") long cpf);
}
