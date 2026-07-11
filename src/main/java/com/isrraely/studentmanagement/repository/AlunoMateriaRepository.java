package com.isrraely.studentmanagement.repository;

import com.isrraely.studentmanagement.entity.AlunoMateria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoMateriaRepository extends JpaRepository<AlunoMateria, Long> {
}