package com.exemplo.excelgenerator.repository;

import com.exemplo.excelgenerator.entity.DadosRemuneracao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository para dados de remuneração.
 */
@Repository
public interface DadosRemuneracaoRepository extends JpaRepository<DadosRemuneracao, Long> {
    
    @Query(value = "SELECT * FROM dados_remuneracao WHERE cpf = :cpf", nativeQuery = true)
    List<DadosRemuneracao> findByCpf(@Param("cpf") long cpf);
}
