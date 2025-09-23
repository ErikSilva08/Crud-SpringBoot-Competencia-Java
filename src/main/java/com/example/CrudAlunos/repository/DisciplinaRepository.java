package com.example.CrudAlunos.repository;

import com.example.CrudAlunos.entity.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{
    Optional<Disciplina> findByName(String name);

}
