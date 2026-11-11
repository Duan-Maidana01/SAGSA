package com.DS.SAGSA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DS.SAGSA.models.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
