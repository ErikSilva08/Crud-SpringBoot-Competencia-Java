package com.example.CrudAlunos.repository;

import com.example.CrudAlunos.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
