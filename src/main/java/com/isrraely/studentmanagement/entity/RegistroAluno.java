package com.isrraely.studentmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "REGISTRO_ALUNO")
public class RegistroAluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matricula;

    private String nome;

    private String sexo;

    private LocalDate dataNascimento;

    @OneToMany(
            mappedBy = "aluno",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<AlunoMateria> materias = new ArrayList<>();
}