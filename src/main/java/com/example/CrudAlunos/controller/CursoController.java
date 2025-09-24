package com.example.CrudAlunos.controller;

import com.example.CrudAlunos.entity.Curso;
import com.example.CrudAlunos.entity.Professor;
import com.example.CrudAlunos.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CursoController {

    private final CursoService service;

    @PostMapping
    public ResponseEntity<Curso> createCurso(@RequestBody String nome) {
        return new ResponseEntity<>(service.createCurso(nome), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Curso>> listAllCursos() {
        return ResponseEntity.ok(service.listAllCursos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> listCursoById(@PathVariable Long id) {
        return ResponseEntity.ok(service.listCursoById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable Long id) {
        service.deleteCurso(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> updateCurso(@PathVariable Long id, @RequestBody String newName) {
        return ResponseEntity.ok(service.updateCurso(id, newName));
    }

    @GetMapping("/{cursoId}/professores")
    public ResponseEntity<Set<Professor>> listarProfessoresDoCurso(@PathVariable Long cursoId) {
        return ResponseEntity.ok(service.listarProfessoresDoCurso(cursoId));
    }
}
