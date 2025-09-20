package com.example.CrudAlunos.dto;

import com.example.CrudAlunos.entity.Aluno;
import com.example.CrudAlunos.enuns.AlunoStatus;

import java.time.LocalDate;

public record AlunoResponseDto(Long id,
                               String name,
                               Integer age,
                               String email,
                               LocalDate register,
                               AlunoStatus status) {
    public AlunoResponseDto (Aluno aluno) {
        this(aluno.getId(), aluno.getName(), aluno.getAge(),
                aluno.getEmail(), aluno.getRegister(),aluno.getStatus());
    }
}
