package com.example.CrudAlunos.repository;

import com.example.CrudAlunos.entity.Historico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoRepository extends JpaRepository<Historico, Long> {
}
