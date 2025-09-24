package com.example.CrudAlunos.controller;

import com.example.CrudAlunos.entity.Professor;
import com.example.CrudAlunos.service.ProfessorService;
import com.example.CrudAlunos.dto.ProfessorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/professores")
@RequiredArgsConstructor
public class ProfessorController {
    private final ProfessorService service;

    @PostMapping
    public ResponseEntity<Professor> createProfessor(@RequestBody ProfessorDto dto) {
        Professor novoProfessor = service.createProfessor(dto.getName());
        return new ResponseEntity<>(novoProfessor, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Professor>> getAllProfessors() {
        return ResponseEntity.ok(service.listAllProfessores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable Long id) {
        return ResponseEntity.ok(service.listProfessorById(id));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteProfessor(@PathVariable Long id) {
        service.deleteProfessor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{professorId}/adicionar-curso/{cursoId}")
    public ResponseEntity<String> adicionarProfessorACurso(
            @PathVariable Long professorId,
            @PathVariable Long cursoId) {

        service.adicionarProfessorACurso(professorId, cursoId);
        return ResponseEntity.ok("Professor adicionado ao curso com sucesso!");
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Professor> updateProfessor(@PathVariable Long id, @RequestBody ProfessorDto dto) {
//        return ResponseEntity.ok(service.updateProfessor(id, dto.getName()));
//    }
}
