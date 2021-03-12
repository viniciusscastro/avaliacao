package com.rd.treinamentodev.AvaliacaoSpringBoot.service;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.AlunoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.CursoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.InstrutorDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.TurmaDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.AlunoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.InstrutorEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.TurmaEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.CursoRepository;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CursoService cursoService;

    SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

    public List<TurmaDTO> listar(){
        List<TurmaEntity> listEntity = turmaRepository.findAll();
        List<TurmaDTO> listDTO = new ArrayList<>();
        for(TurmaEntity Entity: listEntity){
            TurmaDTO turmaDTO = new TurmaDTO();
            turmaDTO.setDtInicio(Entity.getDtInicio().toString());
            turmaDTO.setDtFim(Entity.getDtFinal().toString());
            CursoDTO cursoConvertido = cursoService.conversao(Entity.getCurso());
            turmaDTO.setCurso(cursoConvertido);

            listDTO.add(turmaDTO);
            List<AlunoDTO> alunoDTOConvert = new ArrayList<>();
            for (AlunoEntity alunoEntity: Entity.getAlunos()){
                AlunoDTO alunoDTO = new AlunoDTO();
                alunoDTO.setNome(alunoEntity.getNomeAluno());
                alunoDTO.setCpf(alunoEntity.getCpf());
                alunoDTOConvert.add(alunoDTO);
            }
            turmaDTO.setAlunos(alunoDTOConvert);

            List<InstrutorDTO> instrutorDTOSConvert = new ArrayList<>();
            for (InstrutorEntity instrutorEntity: Entity.getInstrutores()){
                InstrutorDTO instrutorDTO = new InstrutorDTO();
                instrutorDTO.setNome(instrutorEntity.getNomeInstrutor());
                instrutorDTO.setValorHora(instrutorEntity.getValorHora());
                instrutorDTOSConvert.add(instrutorDTO);
            }
            turmaDTO.setInstrutores(instrutorDTOSConvert);
            listDTO.add(turmaDTO);
        }
        //TODO implementar a conversão da lista de objetos de TurmaEntity para TurmaDTO e retornar a listDTO preenchida




        return listDTO;
    }

}
