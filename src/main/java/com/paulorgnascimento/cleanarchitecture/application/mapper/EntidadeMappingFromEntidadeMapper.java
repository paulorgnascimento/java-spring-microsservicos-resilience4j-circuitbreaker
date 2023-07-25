package com.paulorgnascimento.cleanarchitecture.application.mapper;
import com.paulorgnascimento.cleanarchitecture.domain.entity.Entidade;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.entity.EntidadeMapping;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EntidadeMappingFromEntidadeMapper {
    EntidadeMapping fromEntidade(Entidade entity);
}
