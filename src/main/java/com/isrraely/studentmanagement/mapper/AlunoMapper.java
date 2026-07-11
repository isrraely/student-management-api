package com.isrraely.studentmanagement.mapper;

import com.isrraely.studentmanagement.dto.AlunoRequest;
import com.isrraely.studentmanagement.dto.MateriaRequest;
import com.isrraely.studentmanagement.dto.AlunoResponse;
import com.isrraely.studentmanagement.dto.MateriaResponse;
import com.isrraely.studentmanagement.entity.AlunoMateria;
import com.isrraely.studentmanagement.entity.RegistroAluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoMapper {

    private AlunoMapper() {
    }

    public static RegistroAluno toEntity(AlunoRequest request) {

        RegistroAluno aluno = new RegistroAluno();

        aluno.setMatricula(request.getMatricula());
        aluno.setNome(request.getNome());
        aluno.setSexo(request.getSexo());
        aluno.setDataNascimento(request.getDataNascimento());

        List<AlunoMateria> materias = new ArrayList<>();

        for (MateriaRequest dto : request.getMaterias()) {

            AlunoMateria materia = new AlunoMateria();

            materia.setMateria(dto.getMateria());
            materia.setNota(dto.getNota());

            materia.setAluno(aluno);

            materias.add(materia);
        }

        aluno.setMaterias(materias);

        return aluno;
    }

    public static AlunoResponse toResponse(RegistroAluno aluno) {

        AlunoResponse response = new AlunoResponse();

        response.setMatricula(aluno.getMatricula());
        response.setNome(aluno.getNome());
        response.setSexo(aluno.getSexo());
        response.setDataNascimento(aluno.getDataNascimento());

        List<MateriaResponse> materias =
                aluno.getMaterias()
                        .stream()
                        .map(AlunoMapper::toMateriaResponse)
                        .toList();

        response.setMaterias(materias);

        return response;
    }

    private static MateriaResponse toMateriaResponse(AlunoMateria materia) {

        MateriaResponse response = new MateriaResponse();

        response.setMateria(materia.getMateria());
        response.setNota(materia.getNota());

        return response;
    }

}