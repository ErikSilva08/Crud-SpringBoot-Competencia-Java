package com.example.CrudAlunos.dto;

import com.example.CrudAlunos.entity.Turma;
import com.example.CrudAlunos.enuns.StatusTurma;

public record TurmaResponseDto(
        Long id,
        String nome,
        String semestre,
        Integer ano,
        String turno,
        String sala,
        Integer capacidadeMaxima,
        StatusTurma status,
        String cursoNome,
        String disciplinaNome,
        String professorNome
) {
    public TurmaResponseDto(Turma turma) {
        this(
                turma.getId(),
                turma.getNome(),
                turma.getSemestre(),
                turma.getAno(),
                turma.getTurno(),
                turma.getSala(),
                turma.getCapacidadeMaxima(),
                turma.getStatus(),
                turma.getCurso().getName(),
                turma.getDisciplina().getName(),
                turma.getProfessor().getName()
        );
    }
}
