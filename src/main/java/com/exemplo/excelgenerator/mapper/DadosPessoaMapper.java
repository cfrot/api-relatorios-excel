package com.exemplo.excelgenerator.mapper;

import com.exemplo.excelgenerator.entity.DadosPessoa;
import com.exemplo.excelgenerator.model.DadosPessoaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DadosPessoaMapper {

    DadosPessoaResponse toResponse(DadosPessoa entity);

    List<DadosPessoaResponse> toResponseList(List<DadosPessoa> entities);
}
