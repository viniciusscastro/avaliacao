package com.rd.treinamentodev.AvaliacaoSpringBoot.service;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.CursoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.ResultData;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    @Autowired
    CursoRepository cursoRepository;


    public ResponseEntity cadastrarCurso(CursoDTO cursoDTO) {
        if(cursoDTO.getCargaHoraria()==null) {
            ResultData resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "O campo de carga horaria não foi preenchido");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }
        if(cursoDTO.getNome()==""){
            ResultData resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "O campo de nome não foi preenchido");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }
        CursoEntity cursoEntity = new CursoEntity();
        cursoEntity.setNomeCurso(cursoDTO.getNome());
        cursoEntity.setNrCargaHoraria(cursoDTO.getCargaHoraria());
        cursoRepository.save(cursoEntity);
        ResultData resultData = new ResultData(HttpStatus.CREATED.value(), "Curso cadastrado com sucesso", cursoEntity.getIdCurso());
        return ResponseEntity.status(HttpStatus.CREATED).body(resultData);
    }

    public CursoDTO conversao(CursoEntity cursoEntity){
        CursoDTO cursoDTO = new CursoDTO();
        cursoDTO.setNome(cursoEntity.getNomeCurso());
        cursoDTO.setCargaHoraria(cursoEntity.getNrCargaHoraria());

        return cursoDTO;

    }

}
