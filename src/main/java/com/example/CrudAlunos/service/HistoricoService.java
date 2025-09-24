package com.example.CrudAlunos.service;

import com.example.CrudAlunos.entity.Disciplina;
import com.example.CrudAlunos.entity.Historico;
import com.example.CrudAlunos.repository.HistoricoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
@Service
@RequiredArgsConstructor

public class HistoricoService {
    private final HistoricoRepository repository;

    @Transactional
    public List<Historico> listAllHistorico() {
        return repository.findAll();
    }

}
