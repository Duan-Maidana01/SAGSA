package com.DS.SAGSA.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.DS.SAGSA.models.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {

    @Transactional(readOnly = true)
    Optional<Perfil> findByNome(String nome);

    boolean existsByNome(String nome);

    boolean existsByNomeAndIdNot(String nome, Long id);
}
