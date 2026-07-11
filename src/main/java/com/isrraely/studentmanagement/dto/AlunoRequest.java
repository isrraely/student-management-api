package com.isrraely.studentmanagement.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class AlunoRequest {

    private Long matricula;

    @NotBlank
    private String nome;

    @NotBlank
    private String sexo;

    @NotNull
    private LocalDate dataNascimento;

    @Valid
    private List<MateriaRequest> materias;
}