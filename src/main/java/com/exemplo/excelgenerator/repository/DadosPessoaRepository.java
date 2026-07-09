package com.exemplo.excelgenerator.repository;

import com.exemplo.excelgenerator.entity.DadosPessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository para dados de pessoa.
 */
@Repository
public interface DadosPessoaRepository extends JpaRepository<DadosPessoa, Long> {
    
    @Query(value = "SELECT * FROM dados_pessoa WHERE cpf = :cpf", nativeQuery = true)
    List<DadosPessoa> findByCpf(@Param("cpf") String cpf);
}
