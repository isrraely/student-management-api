package com.isrraely.studentmanagement.service;

import com.isrraely.studentmanagement.dto.AlunoRequest;
import com.isrraely.studentmanagement.dto.AlunoResponse;
import com.isrraely.studentmanagement.entity.AlunoMateria;
import com.isrraely.studentmanagement.entity.RegistroAluno;
import com.isrraely.studentmanagement.exception.ResourceNotFoundException;
import com.isrraely.studentmanagement.mapper.AlunoMapper;
import com.isrraely.studentmanagement.repository.RegistroAlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final RegistroAlunoRepository repository;

    public AlunoService(RegistroAlunoRepository repository) {
        this.repository = repository;
    }

    public AlunoResponse salvar(AlunoRequest request) {

        RegistroAluno aluno = AlunoMapper.toEntity(request);

        RegistroAluno salvo = repository.save(aluno);

        return AlunoMapper.toResponse(salvo);
    }

    public List<AlunoResponse> listarTodos() {

        return repository.findAll()
                .stream()
                .map(AlunoMapper::toResponse)
                .toList();
    }

    public List<AlunoResponse> listarNotasMaioresQueOito() {

        return repository.buscarNotasMaioresQueOito()
                .stream()
                .map(AlunoMapper::toResponse)
                .toList();
    }

    public AlunoResponse atualizar(Long matricula, AlunoRequest request) {

        RegistroAluno aluno = repository.findById(matricula)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Aluno não encontrado."
                        ));

        aluno.setNome(request.getNome());
        aluno.setSexo(request.getSexo());
        aluno.setDataNascimento(request.getDataNascimento());

        aluno.getMaterias().clear();

        RegistroAluno novoAluno = AlunoMapper.toEntity(request);

        for (AlunoMateria materia : novoAluno.getMaterias()) {

            materia.setAluno(aluno);

            aluno.getMaterias().add(materia);
        }

        RegistroAluno atualizado = repository.save(aluno);

        return AlunoMapper.toResponse(atualizado);
    }
}