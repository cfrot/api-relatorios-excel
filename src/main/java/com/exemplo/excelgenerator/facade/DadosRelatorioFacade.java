package com.exemplo.excelgenerator.facade;

import com.exemplo.excelgenerator.model.DadosRelatorioResponse;
import com.exemplo.excelgenerator.service.DadosRelatorioService;
import com.exemplo.excelgenerator.service.XlsxService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class DadosRelatorioFacade {

    private final DadosRelatorioService dadosRelatorioService;
    private final XlsxService xlsxService;


    public byte[] gerarRelatorio(long cpf) throws IOException {
        log.info("Iniciando geração de relatório para CPF: {}", cpf);

        // Busca dados consolidados de todas as APIs
        DadosRelatorioResponse dadosConsolidados = 
            dadosRelatorioService.obterRelatorioCompletoPorCpf(cpf);

        // Valida se encontrou dados
        if (dadosConsolidados == null
                || dadosConsolidados.getDadosPessoa() == null
                || dadosConsolidados.getDadosPessoa().isEmpty()) {

            log.warn("Nenhum dado encontrado para CPF: {}", cpf);
            throw new IllegalArgumentException(
                "Nenhum dado encontrado para o CPF informado"
            );
        }

        log.info("Dados encontrados para CPF: {}. Gerando Excel...", cpf);

        // Gera Excel
        return xlsxService.gerarArquivoXlsx(dadosConsolidados);
    }
}
