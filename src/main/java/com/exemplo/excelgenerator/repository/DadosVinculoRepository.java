package com.exemplo.excelgenerator.repository;

import com.exemplo.excelgenerator.model.DadosVinculoResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository para dados de vínculo.
 * 
 * Retorna diretamente o Response via projection na query nativa.
 */
@Repository
public interface DadosVinculoRepository extends JpaRepository<DadosVinculoResponse, Long> {
    
    @Query(value = "SELECT cpf, possui_vinculo, matricula, codigo_cbo, " +
                   "natureza_atividade, tipo_regime_trabalhista, " +
                   "tipo_regime_previdenciario, data_admissao " +
                   "FROM dados_vinculo WHERE cpf = :cpf", nativeQuery = true)
    List<DadosVinculoResponse> findByCpf(@Param("cpf") long cpf);
}
