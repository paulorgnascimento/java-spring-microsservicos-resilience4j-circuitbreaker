package com.paulorgnascimento.cleanarchitecture.application.mapper;
import com.paulorgnascimento.cleanarchitecture.domain.entity.Entidade;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.entity.TB_Entidade;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TB_EntidadeMapper {
    TB_Entidade toTableDto(Entidade entity);
}
