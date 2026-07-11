package com.isrraely.studentmanagement.controller;

import com.isrraely.studentmanagement.dto.AlunoRequest;
import com.isrraely.studentmanagement.dto.AlunoResponse;
import com.isrraely.studentmanagement.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @PostMapping
    public AlunoResponse salvar(@Valid @RequestBody AlunoRequest request) {
        return service.salvar(request);
    }

    @GetMapping
    public List<AlunoResponse> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/notas-superiores")
    public List<AlunoResponse> listarNotasMaioresQueOito() {
        return service.listarNotasMaioresQueOito();
    }

    @PutMapping("/{matricula}")
    public AlunoResponse atualizar(
            @PathVariable Long matricula,
            @Valid @RequestBody AlunoRequest request) {

        return service.atualizar(matricula, request);
    }
}