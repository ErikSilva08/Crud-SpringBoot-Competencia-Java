package com.example.CrudAlunos.repository;

import com.example.CrudAlunos.entity.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
}
