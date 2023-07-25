package com.paulorgnascimento.cleanarchitecture.application.services;

import com.paulorgnascimento.cleanarchitecture.application.dto.EntidadeDto;
import com.paulorgnascimento.cleanarchitecture.application.mapper.EntidadeFromDtoMapper;
import com.paulorgnascimento.cleanarchitecture.application.mapper.EntidadeMappingFromEntidadeMapper;
import com.paulorgnascimento.cleanarchitecture.domain.entity.Entidade;
import com.paulorgnascimento.cleanarchitecture.infrastructure.gateway.Todo;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.entity.EntidadeMapping;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.repository.EntidadeRepository;
import org.springframework.stereotype.Service;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import java.util.Random;

@Service
public class EntidadeServiceImpl implements EntidadeService {

    private static final String MY_SERVICE = "myService";

    private final EntidadeFromDtoMapper entidadeFromDtoMapper;
    private final EntidadeMappingFromEntidadeMapper entidadeTableDtoMapper;
    private final EntidadeRepository entidadeTableDtoRepository;
    private final GetTodoService getTodoService;
    private Random random = new Random();


    public EntidadeServiceImpl(EntidadeFromDtoMapper entidadeFromDtoMapper,
                               EntidadeMappingFromEntidadeMapper entidadeTableDtoMapper,
                               EntidadeRepository entidadeRepository, GetTodoService getTodoService) {
        this.entidadeFromDtoMapper = entidadeFromDtoMapper;
        this.entidadeTableDtoMapper = entidadeTableDtoMapper;
        this.entidadeTableDtoRepository = entidadeRepository;
        this.getTodoService = getTodoService;
    }
    @CircuitBreaker(name = MY_SERVICE, fallbackMethod = "myServiceFallback")
    @Override
    public void criarEntidade(EntidadeDto entidadeDto) {

        paraTestarOCircuitBreaker_Gerar50PorcentoDeErroProposital();

        Todo todo = getTodoService.execute(1);

        Entidade entidade = entidadeFromDtoMapper.fromDto(entidadeDto);
        EntidadeMapping entidadeMapping = entidadeTableDtoMapper.fromEntidade(entidade);

        entidadeTableDtoRepository.save(entidadeMapping);
    }

    public String myServiceFallback(Exception e) {

        return null;
    }

    public void paraTestarOCircuitBreaker_Gerar50PorcentoDeErroProposital() {
        if (random.nextDouble() < 0.5) {
            throw new RuntimeException("Erro simulado");
        }
    }
}
