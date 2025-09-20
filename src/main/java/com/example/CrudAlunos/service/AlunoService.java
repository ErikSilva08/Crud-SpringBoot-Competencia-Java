package com.example.CrudAlunos.service;

import com.example.CrudAlunos.dto.AlunoRequestDto;
import com.example.CrudAlunos.dto.AlunoResponseDto;
import com.example.CrudAlunos.entity.Aluno;
import com.example.CrudAlunos.enuns.AlunoStatus;
import com.example.CrudAlunos.repository.AlunoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlunoService {
    public final AlunoRepository repository;

    public AlunoResponseDto createNewAluno (AlunoRequestDto requestDto) {
        Aluno alunoCriado = new Aluno(requestDto);
        Aluno alunoSalvo = repository.save(alunoCriado);
        return new AlunoResponseDto(alunoSalvo);
    }

    public List<AlunoResponseDto> listAllAlunos () {
        return repository.findAll().stream()
                .map(aluno -> new AlunoResponseDto(aluno))
                .collect(Collectors.toList());
    }

    public AlunoResponseDto listAlunoById (Long id) {
        Aluno alunoId = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("id: " + id + "not found!"));
        return new AlunoResponseDto(alunoId);
    }

    public void cancelAluno (Long id) {
        Aluno alunoCancel = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("id: " + id + "not found!"));
        alunoCancel.setStatus(AlunoStatus.MATRICULACANCELADA);
        repository.save(alunoCancel);
    }
}
