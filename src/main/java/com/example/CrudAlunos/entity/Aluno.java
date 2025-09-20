package com.example.CrudAlunos.entity;

import com.example.CrudAlunos.dto.AlunoRequestDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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

    //Criem os atributos de relacionamento aqui e o lombok cria os Getters e Setters automatico!

    public Aluno (AlunoRequestDto requestDto) {
        this.name = requestDto.name();
        this.age = requestDto.age();
        this.email = requestDto.email();
    }
}
