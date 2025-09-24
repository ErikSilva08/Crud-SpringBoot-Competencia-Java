package com.example.CrudAlunos.service;
import com.example.CrudAlunos.entity.Disciplina;
import com.example.CrudAlunos.repository.DisciplinaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Service
@RequiredArgsConstructor
public class DisciplinaService {
    private final DisciplinaRepository repository;

    @Transactional
    public Disciplina createNewDisciplina(String nomeDisciplina){
        Disciplina novaDisciplina = new Disciplina(nomeDisciplina);
        return repository.save(novaDisciplina);
    }

    public List<Disciplina> listAllDisciplinas() {
        return repository.findAll();
    }

    public Disciplina listDisciplinaById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Disciplina com id: "+ id + " não encontrada"));
    }

    @Transactional
    public void deleteDisciplina(Long id){
        if (!repository.existsById(id)){
            throw new EntityNotFoundException("Disciplina não encontrada");
        }
        repository.deleteById(id);
    }
    
    @Transactional
    public Disciplina updateDisciplina(Long id, String newName){
        Disciplina disciplina = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Disciplina não encontrada com esse ID"));
        disciplina.setName(newName);
        return repository.save(disciplina);
    }
}
