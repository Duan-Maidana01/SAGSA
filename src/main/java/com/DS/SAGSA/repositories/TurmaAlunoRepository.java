package com.DS.SAGSA.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DS.SAGSA.models.TurmaAluno;
import com.DS.SAGSA.models.TurmaAlunoId;

@Repository
public interface TurmaAlunoRepository extends JpaRepository<TurmaAluno, TurmaAlunoId> {

    List<TurmaAluno> findByTurma_IdOrderByAluno_NomeAsc(Long turmaId);

    List<TurmaAluno> findByAluno_IdOrderByDataMatriculaDesc(Long alunoId);
}
