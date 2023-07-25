package com.paulorgnascimento.cleanarchitecture.interfaces.rest.controller;

import com.paulorgnascimento.cleanarchitecture.application.dto.EntidadeDto;
import com.paulorgnascimento.cleanarchitecture.application.services.EntidadeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entidades")
public class EntidadeController {

    private final EntidadeService entidadeService;

    public EntidadeController(EntidadeService entidadeService) {
        this.entidadeService = entidadeService;
    }

    @PostMapping
    public ResponseEntity<Void> criarEntidade(@RequestBody EntidadeDto entidadeDto) {
        entidadeService.criarEntidade(entidadeDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
