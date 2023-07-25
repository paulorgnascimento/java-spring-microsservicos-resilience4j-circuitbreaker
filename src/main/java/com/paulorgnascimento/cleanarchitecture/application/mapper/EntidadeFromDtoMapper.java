package com.paulorgnascimento.cleanarchitecture.application.mapper;

import com.paulorgnascimento.cleanarchitecture.application.dto.EntidadeDto;
import com.paulorgnascimento.cleanarchitecture.domain.entity.Entidade;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EntidadeFromDtoMapper {
    Entidade fromDto(EntidadeDto dto);
}
