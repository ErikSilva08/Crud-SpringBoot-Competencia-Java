package com.example.CrudAlunos.service;

import com.example.CrudAlunos.dto.AlunoRequestDto;
import com.example.CrudAlunos.dto.AlunoResponseDto;
import com.example.CrudAlunos.entity.Aluno;
import com.example.CrudAlunos.enuns.AlunoStatus;
import com.example.CrudAlunos.repository.AlunoRepository;
import com.example.CrudAlunos.entity.Disciplina;
import com.example.CrudAlunos.repository.DisciplinaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlunoService {
    public final AlunoRepository repository;
    public final DisciplinaRepository disciplinaRepository;

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

    @Transactional
    public void adicionarAlunoADisciplina(String alunoName, String disciplinaName) {
        Optional<Aluno> alunoOptional = repository.findByName(alunoName);
        Aluno aluno = alunoOptional
                .orElseGet(() -> repository.save(new Aluno(null, alunoName, 0, "", null, null, new HashSet<>())));

        Disciplina disciplina = disciplinaRepository .findByName(disciplinaName)
                .orElseGet(() -> disciplinaRepository .save(new Disciplina(disciplinaName)));

        aluno.getDisciplinas().add(disciplina);

        repository.save(aluno);

        System.out.println("Aluno " + aluno.getName() + " adicionado à disciplina " + disciplina.getName() + " com sucesso.");
    }
}
