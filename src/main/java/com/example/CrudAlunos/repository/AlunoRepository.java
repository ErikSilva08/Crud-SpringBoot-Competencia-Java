package com.example.CrudAlunos.repository;

import com.example.CrudAlunos.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Optional<Aluno> findByName(String name);
}
