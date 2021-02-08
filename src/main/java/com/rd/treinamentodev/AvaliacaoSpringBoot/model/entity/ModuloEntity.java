package com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@Entity
@Table(name = "tb_modulo")
public class ModuloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MODULO")
    private BigInteger idModulo;

    @Column(name = "DS_NOME")
    private String dsNome;

    @ManyToOne
    @JoinColumn(name = "ID_INSTRUTOR")
    private InstrutorEntity instrutor;

}
