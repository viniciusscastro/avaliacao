package com.rd.treinamentodev.AvaliacaoSpringBoot.service;

import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.ModuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ModuloService {
    @Autowired
    ModuloRepository moduloRepository;

    public ResponseEntity buscarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(moduloRepository.findAll());
    }
}
