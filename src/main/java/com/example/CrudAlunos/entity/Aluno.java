package com.example.CrudAlunos.entity;

import com.example.CrudAlunos.dto.AlunoRequestDto;
import com.example.CrudAlunos.enuns.AlunoStatus;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;

import java.time.LocalDate;
import java.util.HashSet;

@Entity
@Table(name = "tb_alunos")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false,length = 100)
    private String email;
    private LocalDate register = LocalDate.now();
    private AlunoStatus status = AlunoStatus.MATRICULADO;

    //Criem os atributos de relacionamento aqui e o lombok cria os Getters e Setters automatico!

    @ManyToMany
    @JoinTable(
            name = "aluno_disciplina",
            joinColumns = @JoinColumn(name = "aluno_id"),
            inverseJoinColumns = @JoinColumn(name = "disciplina_id")
    )
    private Set<Disciplina> disciplinas = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Turma turma;

    public Aluno (AlunoRequestDto requestDto) {
        this.name = requestDto.name();
        this.age = requestDto.age();
        this.email = requestDto.email();
    }

    public <E> Aluno(Object o, String alunoName, int i, String s, Object o1, Object o2, HashSet<E> es) {

    }
}
