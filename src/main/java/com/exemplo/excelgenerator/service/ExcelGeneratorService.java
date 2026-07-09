package com.exemplo.excelgenerator.service;

import com.exemplo.excelgenerator.model.DadoExemplo;
import com.exemplo.excelgenerator.model.RelatorioRequest;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

@Service
public class ExcelGeneratorService {

    public ByteArrayInputStream gerarRelatorio(RelatorioRequest request) {
        try (Workbook workbook = new XSSFWorkbook();
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            // Cria aba
            Sheet sheet = workbook.createSheet("Relatório");

            // Estilo do header
            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerStyle.setFont(headerFont);

            // Cria header
            Row headerRow = sheet.createRow(0);
            String[] headers = {"Nome", "CPF", "Valor", "Data"};
            
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
                cell.setCellStyle(headerStyle);
                sheet.autoSizeColumn(i);
            }

            // Adiciona dados
            int rowIdx = 1;
            for (DadoExemplo dado : request.getDados()) {
                Row row = sheet.createRow(rowIdx++);
                
                row.createCell(0).setCellValue(dado.getNome());
                row.createCell(1).setCellValue(dado.getCpf());
                row.createCell(2).setCellValue(dado.getValor());
                
                if (dado.getData() != null) {
                    row.createCell(3).setCellValue(
                        dado.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                    );
                } else {
                    row.createCell(3).setCellValue("");
                }
            }

            // Auto-ajusta colunas
            for (int i = 0; i < headers.length; i++) {
                sheet.autoSizeColumn(i);
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());

        } catch (IOException e) {
            throw new RuntimeException("Erro ao gerar relatório Excel", e);
        }
    }
}
