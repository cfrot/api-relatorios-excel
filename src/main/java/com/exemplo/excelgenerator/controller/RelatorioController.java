package com.exemplo.excelgenerator.controller;

import com.exemplo.excelgenerator.facade.DadosRelatorioFacade;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/api/relatorios")
@RequiredArgsConstructor
public class RelatorioController {

    private final DadosRelatorioFacade dadosRelatorioFacade;

    @ApiOperation(value = "Gerar relatório XLSX por CPF", response = byte[].class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Relatório gerado com sucesso"),
        @ApiResponse(code = 400, message = "CPF inválido ou dados inexistentes"),
        @ApiResponse(code = 401, message = "Acesso não autorizado"),
        @ApiResponse(code = 403, message = "Acesso proibido"),
        @ApiResponse(code = 500, message = "Erro interno do servidor")
    })
    @GetMapping("/{cpf}")
    public ResponseEntity<byte[]> downloadRelatorio(
            @PathVariable Long cpf,
            Authentication authentication) {

        String usuarioLogado = (authentication != null) ? authentication.getName() : "ANÔNIMO";
        log.info("Solicitação de relatório para o CPF: {} pelo usuário: {}", cpf, usuarioLogado);

        try {
            byte[] xlsxData = dadosRelatorioFacade.gerarRelatorio(cpf);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(
                MediaType.parseMediaType(
                    "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
                )
            );
            headers.setContentDispositionFormData(
                "attachment",
                "relatorio_" + cpf + ".xlsx"
            );
            headers.setContentLength(xlsxData.length);

            return new ResponseEntity<>(xlsxData, headers, HttpStatus.OK);

        } catch (IllegalArgumentException e) {
            log.error("Dados não encontrados para o CPF: {}", cpf);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        } catch (IOException e) {
            log.error("Erro de IO ao gerar relatório para o CPF: {} por {}", cpf, usuarioLogado, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
