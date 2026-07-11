package com.isrraely.studentmanagement.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class AlunoResponse {

    private Long matricula;

    private String nome;

    private String sexo;

    private LocalDate dataNascimento;

    private List<MateriaResponse> materias;

}