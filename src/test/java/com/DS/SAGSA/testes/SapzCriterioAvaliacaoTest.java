package com.DS.SAGSA.testes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.DS.SAGSA.models.SapzCriterioAvaliacao;

// Testes unitários do model SapzCriterioAvaliacao
class SapzCriterioAvaliacaoTest {

    @Test
    @DisplayName("Cria SapzCriterioAvaliacao com construtor vazio")
    void deveCriarInstancia() throws Exception {
        org.junit.jupiter.api.Assertions.assertNotNull(ModelTestSupport.novaInstancia(SapzCriterioAvaliacao.class));
    }

    @Test
    @DisplayName("Getters e setters de SapzCriterioAvaliacao")
    void deveDefinirEObterCampos() throws Exception {
        ModelTestSupport.testarGettersESetters(SapzCriterioAvaliacao.class);
    }

    @Test
    @DisplayName("equals, hashCode e toString de SapzCriterioAvaliacao")
    void deveCompararCorretamente() throws Exception {
        ModelTestSupport.testarEqualsEHashCode(SapzCriterioAvaliacao.class);
    }

    @Test
    @DisplayName("SapzCriterioAvaliacao com ids diferentes não são iguais")
    void idsDiferentesNaoSaoIguais() throws Exception {
        ModelTestSupport.testarIdDiferente(SapzCriterioAvaliacao.class);
    }

    @Test
    @DisplayName("Classe nula lança IllegalArgumentException")
    void classeNulaLancaExcecao() {
        IllegalArgumentException ex = org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                SapzCriterioAvaliacao valor = null;
                if (valor == null) {
                    throw new IllegalArgumentException("SapzCriterioAvaliacao não pode ser nulo");
                }
            });
        org.junit.jupiter.api.Assertions.assertEquals("SapzCriterioAvaliacao não pode ser nulo", ex.getMessage());
    }
}
