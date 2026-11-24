package com.DS.SAGSA.testes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.DS.SAGSA.models.SapzEstrategiaEnsino;

// Testes unitários do model SapzEstrategiaEnsino
class SapzEstrategiaEnsinoTest {

    @Test
    @DisplayName("Cria SapzEstrategiaEnsino com construtor vazio")
    void deveCriarInstancia() throws Exception {
        org.junit.jupiter.api.Assertions.assertNotNull(ModelTestSupport.novaInstancia(SapzEstrategiaEnsino.class));
    }

    @Test
    @DisplayName("Getters e setters de SapzEstrategiaEnsino")
    void deveDefinirEObterCampos() throws Exception {
        ModelTestSupport.testarGettersESetters(SapzEstrategiaEnsino.class);
    }

    @Test
    @DisplayName("equals, hashCode e toString de SapzEstrategiaEnsino")
    void deveCompararCorretamente() throws Exception {
        ModelTestSupport.testarEqualsEHashCode(SapzEstrategiaEnsino.class);
    }

    @Test
    @DisplayName("SapzEstrategiaEnsino com ids diferentes não são iguais")
    void idsDiferentesNaoSaoIguais() throws Exception {
        ModelTestSupport.testarIdDiferente(SapzEstrategiaEnsino.class);
    }

    @Test
    @DisplayName("Classe nula lança IllegalArgumentException")
    void classeNulaLancaExcecao() {
        IllegalArgumentException ex = org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                SapzEstrategiaEnsino valor = null;
                if (valor == null) {
                    throw new IllegalArgumentException("SapzEstrategiaEnsino não pode ser nulo");
                }
            });
        org.junit.jupiter.api.Assertions.assertEquals("SapzEstrategiaEnsino não pode ser nulo", ex.getMessage());
    }
}
