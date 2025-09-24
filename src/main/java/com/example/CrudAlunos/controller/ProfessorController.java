package com.example.CrudAlunos.controller;

import com.example.CrudAlunos.entity.Professor;
import com.example.CrudAlunos.service.ProfessorService;
import com.example.CrudAlunos.dto.ProfessorDTO;
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
    public ResponseEntity<Professor> createProfessor(@RequestBody ProfessorDTO dto) {
        Professor novoProfessor = service.createNewProfessor(dto.getName());
        return new ResponseEntity<>(novoProfessor, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Professor>> getAllProfessors() {
        return ResponseEntity.ok(service.listAllProfessors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable Long id) {
        return ResponseEntity.ok(service.listProfessorById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfessor(@PathVariable Long id) {
        service.deleteProfessor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> updateProfessor(@PathVariable Long id, @RequestBody ProfessorDTO dto) {
        return ResponseEntity.ok(service.updateProfessor(id, dto.getName()));
    }
}
