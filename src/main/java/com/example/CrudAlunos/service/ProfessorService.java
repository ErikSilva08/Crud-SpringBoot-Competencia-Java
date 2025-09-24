package com.example.CrudAlunos.service;

import com.example.CrudAlunos.entity.Professor;
import com.example.CrudAlunos.repository.ProfessorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorRepository repository;

    @Transactional
    public Professor createNewProfessor(String name) {
        Professor novoProfessor = new Professor();
        novoProfessor.setName(name);
        return repository.save(novoProfessor);
    }

    public List<Professor> listAllProfessors() {
        return repository.findAll();
    }

    public Professor listProfessorById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Professor com id " + id + " não encontrado"));
    }

    @Transactional
    public void deleteProfessor(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Professor não encontrado");
        }
        repository.deleteById(id);
    }

    @Transactional
    public Professor updateProfessor(Long id, String newName) {
        Professor professor = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Professor não encontrado com esse ID"));
        professor.setName(newName);
        return repository.save(professor);
    }
}
