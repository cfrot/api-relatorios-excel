package com.exemplo.excelgenerator.service;

import com.exemplo.excelgenerator.model.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

@Service
public class XlsxService {

    // cabeçalhos completos para cada aba
    private static final List<String> HEADERS_PESSOA = Arrays.asList(
        "CPF", "Nome", "Data de nascimento"

    );

    private static final List<String> HEADERS_REMUNERACAO = Arrays.asList(
        "CPF", "Matrícula", "Salário Base",
        "Unidade de pagamento", "Grau de exposição", "Data de início"
    );

    private static final List<String> HEADERS_VINCULO = Arrays.asList(
        "CPF", "Possui vínculo?","Matrícula","Data de admissão","Data desligamento", "Tipo contrato",
        "Categoria trabalhador", "Motivo desligamento",
        "Motivo término"
    );

    private static final List<String> HEADERS_DEPENDENTES = Arrays.asList(
        "CPF trabalhador", "Nome dependente", "CPF dependente", "Tipo dependente"
    );

    public byte[] gerarArquivoXlsx(DadosRelatorioResponse dados) throws IOException {
        try (XSSFWorkbook workbook = new XSSFWorkbook();
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

            if (dados != null) {
                criarAba(workbook, "Dados Pessoa", HEADERS_PESSOA,
                    dados.getDadosPessoa(), this::preencherLinhaDadosPessoa);

                criarAba(workbook, "Dados Remuneração", HEADERS_REMUNERACAO,
                    dados.getDadosRemuneracao(), this::preencherLinhaDadosRemuneracao);

                criarAba(workbook, "Dados Vínculo", HEADERS_VINCULO,
                    dados.getDadosVinculo(), this::preencherLinhaDadosVinculo);

                criarAba(workbook, "Dados Dependentes", HEADERS_DEPENDENTES,
                    dados.getDadosDependente(), this::preencherLinhaDadosDependentes);
            }

            workbook.write(outputStream);
            return outputStream.toByteArray();
        }
    }

    private <T> void criarAba(
            Workbook workbook,
            String nomeAba,
            List<String> cabecalhos,
            List<T> dados,
            BiConsumer<Row, T> preenchedorDeLinha) {

        Sheet sheet = workbook.createSheet(nomeAba);

        // cria cabeçalho sempre
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < cabecalhos.size(); i++) {
            headerRow.createCell(i).setCellValue(cabecalhos.get(i));
        }

        // se não houver dados, a aba já é válida
        if (dados == null || dados.isEmpty()) {
            return;
        }

        int rowNum = 1;
        for (T item : dados) {
            Row row = sheet.createRow(rowNum++);
            preenchedorDeLinha.accept(row, item);
        }
    }

    private void preencherLinhaDadosPessoa(Row row, DadosPessoaResponse item) {
        row.createCell(0).setCellValue(item.getCpf());
        row.createCell(1).setCellValue(item.getNome());
        row.createCell(2).setCellValue(item.getDataNascimento());

    }

    private void preencherLinhaDadosRemuneracao(Row row, DadosRemuneracaoResponse item) {
        row.createCell(0).setCellValue(item.getCpf());
        row.createCell(1).setCellValue(item.getMatricula());
        row.createCell(2).setCellValue(item.getSalarioBase());
        row.createCell(3).setCellValue(item.getUnidadePagto());
        row.createCell(4).setCellValue(item.getGrauExposicao());
        row.createCell(5).setCellValue(item.getDataInicio());
    }

    private void preencherLinhaDadosVinculo(Row row, DadosVinculoResponse item) {
        row.createCell(0).setCellValue(item.getCpf());
        row.createCell(1).setCellValue(item.getPossuiVinculo());
        row.createCell(3).setCellValue(item.getMatricula());
        row.createCell(6).setCellValue(item.getTipoRegimeTrabalhista());
        row.createCell(8).setCellValue(item.getDataAdmissao());
        row.createCell(10).setCellValue(item.getTipoContrato());
        row.createCell(11).setCellValue(item.getDataTerminoContrato());
        row.createCell(21).setCellValue(item.getMotivoDesligamento());
        row.createCell(22).setCellValue(item.getMotivoTermino());

    }

    private void preencherLinhaDadosDependentes(Row row, DadosDependenteResponse item) {
        row.createCell(0).setCellValue(item.getCpfTrabalhador());
        row.createCell(1).setCellValue(item.getNomeDependente());
        row.createCell(2).setCellValue(item.getCpfDependente());
        row.createCell(3).setCellValue(item.getTipoDependente());
    }
}
