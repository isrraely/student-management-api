package com.isrraely.studentmanagement.repository;

import com.isrraely.studentmanagement.entity.RegistroAluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface RegistroAlunoRepository extends JpaRepository<RegistroAluno, Long> {
    @Query("""
    SELECT DISTINCT a
    FROM RegistroAluno a
    JOIN FETCH a.materias m
    WHERE m.nota > 8
    """)
    List<RegistroAluno> buscarNotasMaioresQueOito();
}