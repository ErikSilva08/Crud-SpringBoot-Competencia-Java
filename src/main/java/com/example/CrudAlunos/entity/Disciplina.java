package com.example.CrudAlunos.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_disciplina")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToMany(mappedBy = "disciplinas")
    private Set<Aluno> alunos = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    public Disciplina(String name) { this.name = name; }
}
