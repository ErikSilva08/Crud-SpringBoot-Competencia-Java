package com.example.CrudAlunos.entity;

import com.example.CrudAlunos.enuns.StatusTurma;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_turma")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(nullable = false, length = 10)
    private String semestre;

    @Column(nullable = false)
    private Integer ano;

    private String turno;
    private Integer capacidadeMaxima;
    private String sala;

    @Enumerated(EnumType.STRING)
    private StatusTurma status;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @OneToMany(mappedBy = "turma")
    private Set<Aluno> alunos = new HashSet<>();

}
