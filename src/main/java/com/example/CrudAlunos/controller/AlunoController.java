package com.example.CrudAlunos.controller;

import com.example.CrudAlunos.dto.AlunoRequestDto;
import com.example.CrudAlunos.dto.AlunoResponseDto;
import com.example.CrudAlunos.service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunoController {
    public final AlunoService service;

    @PostMapping
    public ResponseEntity<AlunoResponseDto> createNewAluno (@RequestBody AlunoRequestDto requestDto) {
        return new ResponseEntity<>(service.createNewAluno(requestDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AlunoResponseDto>> listAllAlunos () {
        List<AlunoResponseDto> responseDtoList = service.listAllAlunos();
        return ResponseEntity.ok(responseDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponseDto> listAlunoById (@PathVariable Long id) {
        AlunoResponseDto responseDto = service.listAlunoById(id);
        return ResponseEntity.ok(responseDto);
    }

    @PatchMapping("/{id}/cancel")
    public ResponseEntity<Void> cancelAluno (@PathVariable Long id) {
        service.cancelAluno(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
