package com.example.CrudAlunos.service;

import com.example.CrudAlunos.entity.Curso;
import com.example.CrudAlunos.entity.Professor;
import com.example.CrudAlunos.repository.CursoRepository;
import com.example.CrudAlunos.repository.ProfessorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final CursoRepository cursoRepository;

    public List<Professor> listAllProfessores() {
        return professorRepository.findAll();
    }

    public Professor listProfessorById(Long id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Professor não encontrado"));
    }

    @Transactional
    public Professor createProfessor(String name) {
        return professorRepository.save(new Professor(name));
    }

    @Transactional
    public void adicionarProfessorACurso(Long professorId, Long cursoId) {
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new EntityNotFoundException("Professor não encontrado"));

        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new EntityNotFoundException("Curso não encontrado"));

        professor.getCursos().add(curso);
        professorRepository.save(professor);
    }

    public Set<Curso> listarCursosDoProfessor(Long professorId) {
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new EntityNotFoundException("Professor não encontrado"));
        return professor.getCursos();
    }
}
