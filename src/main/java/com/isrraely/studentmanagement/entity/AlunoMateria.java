package com.isrraely.studentmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ALUNO_MATERIA")
public class AlunoMateria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String materia;

    private Double nota;

    @ManyToOne
    @JoinColumn(name = "matricula")
    private RegistroAluno aluno;
}