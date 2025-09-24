package com.example.CrudAlunos.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TurmaRequestDto {
    private String nome;
    private String semestre;
    private Integer ano;
    private String turno;
    private String sala;
    private Integer capacidadeMaxima;
    private String status;

    private Long cursoId;
    private Long disciplinaId;
    private Long professorId;
}
