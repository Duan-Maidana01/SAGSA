package com.DS.SAGSA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DS.SAGSA.models.Escola;

@Repository
public interface EscolaRepository extends JpaRepository<Escola, Long> {
}
