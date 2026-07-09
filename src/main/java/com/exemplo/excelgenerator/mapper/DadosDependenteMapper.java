package com.exemplo.excelgenerator.mapper;

import com.exemplo.excelgenerator.entity.DadosDependente;
import com.exemplo.excelgenerator.model.DadosDependenteResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DadosDependenteMapper {

    DadosDependenteResponse toResponse(DadosDependente entity);

    List<DadosDependenteResponse> toResponseList(List<DadosDependente> entities);
}
