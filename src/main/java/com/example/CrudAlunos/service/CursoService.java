package com.example.CrudAlunos.service;

import com.example.CrudAlunos.entity.Curso;
import com.example.CrudAlunos.entity.Professor;
import com.example.CrudAlunos.repository.CursoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository repository;

    @Transactional
    public Curso createCurso(String nome) {
        return repository.save(new Curso(nome));
    }

    public List<Curso> listAllCursos() {
        return repository.findAll();
    }

    public Curso listCursoById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Curso não encontrado"));
    }

    @Transactional
    public void deleteCurso(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Curso não encontrado");
        }
        repository.deleteById(id);
    }

    @Transactional
    public Curso updateCurso(Long id, String newName) {
        Curso curso = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Curso não encontrado"));
        curso.setName(newName);
        return repository.save(curso);
    }

    public Set<Professor> listarProfessoresDoCurso(Long cursoId) {
        Curso curso = repository.findById(cursoId)
                .orElseThrow(() -> new EntityNotFoundException("Curso não encontrado"));
        return curso.getProfessores();
    }
}
