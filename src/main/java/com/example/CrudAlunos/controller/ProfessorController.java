package com.example.CrudAlunos.controller;

import com.example.CrudAlunos.entity.Professor;
import com.example.CrudAlunos.entity.Curso;
import com.example.CrudAlunos.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/professores")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService service;

    @PostMapping
    public ResponseEntity<Professor> createProfessor(@RequestBody String name) {
        return new ResponseEntity<>(service.createProfessor(name), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Professor>> listAllProfessores() {
        return ResponseEntity.ok(service.listAllProfessores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> listProfessorById(@PathVariable Long id) {
        return ResponseEntity.ok(service.listProfessorById(id));
    }

    @PostMapping("/{professorId}/adicionar-curso/{cursoId}")
    public ResponseEntity<String> adicionarCurso(
            @PathVariable Long professorId,
            @PathVariable Long cursoId) {
        service.adicionarProfessorACurso(professorId, cursoId);
        return ResponseEntity.ok("Professor adicionado ao curso com sucesso");
    }

    @GetMapping("/{professorId}/cursos")
    public ResponseEntity<Set<Curso>> listarCursosDoProfessor(@PathVariable Long professorId) {
        return ResponseEntity.ok(service.listarCursosDoProfessor(professorId));
    }
}

