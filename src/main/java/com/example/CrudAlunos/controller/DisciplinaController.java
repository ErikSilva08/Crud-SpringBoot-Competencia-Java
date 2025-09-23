package com.example.CrudAlunos.controller;

import com.example.CrudAlunos.entity.Disciplina;
import com.example.CrudAlunos.service.DisciplinaService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/disciplinas")
@RequiredArgsConstructor
public class DisciplinaController {
    private final DisciplinaService service;

    @PostMapping
    public ResponseEntity<Disciplina> createDisciplina(@RequestBody String nomeDisciplina){
        Disciplina novaDisciplina = service.createNewDisciplina(nomeDisciplina);
        return new ResponseEntity<>(novaDisciplina, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Disciplina>> getAllDisciplinas() {
        List<Disciplina> disciplinas = service.listAllDisciplinas();
        return ResponseEntity.ok(disciplinas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> getDisciplinaById(@PathVariable Long id){
        Disciplina disciplina = service.listDisciplinaById(id);
        return ResponseEntity.ok(disciplina);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisciplina(@PathVariable Long id){
        service.deleteDisciplina(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Disciplina> updateDisciplina(@PathVariable Long id, @RequestBody String newName){
        Disciplina disciplinaAtualizada = service.updateDisciplina(id, newName);
        return ResponseEntity.ok(disciplinaAtualizada);
    }
}
