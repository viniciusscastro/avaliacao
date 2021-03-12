package com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_modulo")
public class ModuloEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idModulo;
    private String dsNome;
    @ManyToOne
    @JoinColumn(name ="ID_INSTRUTOR")
    private InstrutorEntity instrutor;
}
