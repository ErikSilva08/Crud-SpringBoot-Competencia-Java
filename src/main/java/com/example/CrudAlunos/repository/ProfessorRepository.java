package com.example.CrudAlunos.repository;

import com.example.CrudAlunos.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {}
