package com.isrraely.studentmanagement.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isrraely.studentmanagement.dto.AlunoRequest;
import com.isrraely.studentmanagement.service.AlunoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;
import java.util.List;

@Configuration
public class DataInitializer implements CommandLineRunner {

    private final AlunoService alunoService;
    private final ObjectMapper objectMapper;

    public DataInitializer(AlunoService alunoService, ObjectMapper objectMapper) {
        this.alunoService = alunoService;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
    try (InputStream inputStream = getClass().getResourceAsStream("/alunos-iniciais.json")) {

    List<AlunoRequest> alunosRequest = objectMapper.readValue(
                    inputStream,
                    new TypeReference<List<AlunoRequest>>() {}
            );

            for (AlunoRequest request : alunosRequest) {
                alunoService.salvar(request);
            }

            System.out.println("Banco de dados populado com sucesso via JSON!");

        } catch (Exception e) {
            System.out.println("Não foi possível carregar os dados iniciais: " + e.getMessage());
        }
    }
}