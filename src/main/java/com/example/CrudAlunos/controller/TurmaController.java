package com.example.CrudAlunos.controller;

import com.example.CrudAlunos.dto.TurmaRequestDto;
import com.example.CrudAlunos.dto.TurmaResponseDto;
import com.example.CrudAlunos.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @PostMapping
    public ResponseEntity<TurmaResponseDto> criar(@RequestBody TurmaRequestDto dto) {
        TurmaResponseDto turma = turmaService.criarTurma(dto);
        return ResponseEntity.ok(turma);
    }

    @GetMapping
    public ResponseEntity<List<TurmaResponseDto>> listar() {
        return ResponseEntity.ok(turmaService.listarTurmas());
    }
}

