package com.example.CrudAlunos.dto;

import org.antlr.v4.runtime.misc.NotNull;

public record AlunoRequestDto(@NotNull
                              String name,
                              @NotNull
                              Integer age,
                              @NotNull
                              String email,
                              Long cursoId) {
}
