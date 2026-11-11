package com.DS.SAGSA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DS.SAGSA.models.EixoTecnologico;

@Repository
public interface EixoTecnologicoRepository extends JpaRepository<EixoTecnologico, Long> {
}
