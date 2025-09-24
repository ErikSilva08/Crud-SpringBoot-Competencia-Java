package com.example.CrudAlunos.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Table(name = "tb_disciplina")
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToMany(mappedBy = "disciplinas")
    private Set<Aluno> alunos = new HashSet<>();

    public Disciplina(String name) {this.name = name;}

}
