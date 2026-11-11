package com.DS.SAGSA.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DS.SAGSA.models.PadraoDesempenho;

@Repository
public interface PadraoDesempenhoRepository extends JpaRepository<PadraoDesempenho, Long> {

    // Lista os registros de um(a) subfunção
    List<PadraoDesempenho> findBySubfuncao_IdOrderByIdAsc(Long subfuncaoId);
}
