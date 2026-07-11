package com.isrraely.studentmanagement.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MateriaRequest {

    @NotBlank
    private String materia;

    @Min(0)
    @Max(10)
    private Double nota;
}