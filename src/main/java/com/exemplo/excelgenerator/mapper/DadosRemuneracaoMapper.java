package com.exemplo.excelgenerator.mapper;

import com.exemplo.excelgenerator.entity.DadosRemuneracao;
import com.exemplo.excelgenerator.model.DadosRemuneracaoResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DadosRemuneracaoMapper {

    DadosRemuneracaoResponse toResponse(DadosRemuneracao entity);

    List<DadosRemuneracaoResponse> toResponseList(List<DadosRemuneracao> entities);
}
