package com.exemplo.excelgenerator.service;

import com.exemplo.excelgenerator.mapper.*;
import com.exemplo.excelgenerator.model.*;
import com.exemplo.excelgenerator.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service responsável por buscar e consolidar dados de múltiplas fontes.
 * 
 * Busca dados de pessoa, remuneração, vínculo e dependentes
 * a partir dos repositories e consolida em um único objeto.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DadosRelatorioService {

    private final DadosPessoaRepository dadosPessoaRepository;
    private final DadosRemuneracaoRepository dadosRemuneracaoRepository;
    private final DadosDependenteRepository dadosDependenteRepository;
    private final DadosVinculoRepository dadosVinculoRepository;

    private final DadosPessoaMapper dadosPessoaMapper;
    private final DadosRemuneracaoMapper dadosRemuneracaoMapper;
    private final DadosDependenteMapper dadosDependenteMapper;


    public List<DadosPessoaResponse> obterDadosPessoaPorCpf(long cpf) {
        log.info("Buscando dados de pessoa para o CPF: {}", cpf);
        return dadosPessoaMapper.toResponseList(
            dadosPessoaRepository.findByCpf(String.valueOf(cpf))
        );
    }


    public List<DadosRemuneracaoResponse> obterDadosRemuneracaoPorCpf(long cpf) {
        log.info("Buscando dados de remuneração para o CPF: {}", cpf);
        return dadosRemuneracaoMapper.toResponseList(
            dadosRemuneracaoRepository.findByCpf(cpf)
        );
    }

    public List<DadosVinculoResponse> obterDadosVinculoPorCpf(long cpf) {
        log.info("Buscando dados de vínculo para o CPF: {}", cpf);
        return dadosVinculoRepository.findByCpf(cpf);
    }


    public List<DadosDependenteResponse> obterDadosDependentePorCpf(long cpf) {
        log.info("Buscando dados de dependente para o CPF: {}", cpf);
        return dadosDependenteMapper.toResponseList(
            dadosDependenteRepository.findByCpf(cpf)
        );
    }

    public DadosRelatorioResponse obterRelatorioCompletoPorCpf(long cpf) {
        log.info("Iniciando consolidação de dados de relatório para o CPF: {}", cpf);

        List<DadosPessoaResponse> pessoas = this.obterDadosPessoaPorCpf(cpf);
        List<DadosRemuneracaoResponse> remuneracoes = this.obterDadosRemuneracaoPorCpf(cpf);
        List<DadosVinculoResponse> vinculos = this.obterDadosVinculoPorCpf(cpf);
        List<DadosDependenteResponse> dependentes = this.obterDadosDependentePorCpf(cpf);

        return DadosRelatorioResponse.builder()
            .dadosPessoa(pessoas)
            .dadosRemuneracao(remuneracoes)
            .dadosVinculo(vinculos)
            .dadosDependente(dependentes)
            .build();
    }
}
