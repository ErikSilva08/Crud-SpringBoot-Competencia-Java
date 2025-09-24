package com.example.CrudAlunos.service;

import com.example.CrudAlunos.dto.TurmaRequestDto;
import com.example.CrudAlunos.dto.TurmaResponseDto;
import com.example.CrudAlunos.entity.Turma;
import com.example.CrudAlunos.enuns.StatusTurma;
import com.example.CrudAlunos.repository.CursoRepository;
import com.example.CrudAlunos.repository.DisciplinaRepository;
import com.example.CrudAlunos.repository.ProfessorRepository;
import com.example.CrudAlunos.repository.TurmaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TurmaService {

    private final TurmaRepository turmaRepository;
    private final CursoRepository cursoRepository;
    private final DisciplinaRepository disciplinaRepository;
    private final ProfessorRepository professorRepository;

    public TurmaResponseDto criarTurma(TurmaRequestDto dto) {
        Turma turma = new Turma();
        turma.setNome(dto.getNome());
        turma.setSemestre(dto.getSemestre());
        turma.setAno(dto.getAno());
        turma.setTurno(dto.getTurno());
        turma.setSala(dto.getSala());
        turma.setCapacidadeMaxima(dto.getCapacidadeMaxima());
        turma.setStatus(StatusTurma.valueOf(dto.getStatus().toUpperCase()));

        turma.setCurso(cursoRepository.findById(dto.getCursoId())
                .orElseThrow(() -> new EntityNotFoundException("Curso não encontrado")));
        turma.setDisciplina(disciplinaRepository.findById(dto.getDisciplinaId())
                .orElseThrow(() -> new EntityNotFoundException("Disciplina não encontrada")));
        turma.setProfessor(professorRepository.findById(dto.getProfessorId())
                .orElseThrow(() -> new EntityNotFoundException("Professor não encontrado")));

        Turma turmaSalva = turmaRepository.save(turma);

        return new TurmaResponseDto(turmaSalva);
    }

    public List<TurmaResponseDto> listarTurmas() {
        return turmaRepository.findAll()
                .stream()
                .map(TurmaResponseDto::new)
                .toList();
    }
}
