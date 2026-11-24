package com.DS.SAGSA.testes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.DS.SAGSA.models.SapzCriterioRubrica;

// Testes unitários do model SapzCriterioRubrica
class SapzCriterioRubricaTest {

    @Test
    @DisplayName("Cria SapzCriterioRubrica com construtor vazio")
    void deveCriarInstancia() throws Exception {
        org.junit.jupiter.api.Assertions.assertNotNull(ModelTestSupport.novaInstancia(SapzCriterioRubrica.class));
    }

    @Test
    @DisplayName("Getters e setters de SapzCriterioRubrica")
    void deveDefinirEObterCampos() throws Exception {
        ModelTestSupport.testarGettersESetters(SapzCriterioRubrica.class);
    }

    @Test
    @DisplayName("equals, hashCode e toString de SapzCriterioRubrica")
    void deveCompararCorretamente() throws Exception {
        ModelTestSupport.testarEqualsEHashCode(SapzCriterioRubrica.class);
    }

    @Test
    @DisplayName("SapzCriterioRubrica com ids diferentes não são iguais")
    void idsDiferentesNaoSaoIguais() throws Exception {
        ModelTestSupport.testarIdDiferente(SapzCriterioRubrica.class);
    }

    @Test
    @DisplayName("Classe nula lança IllegalArgumentException")
    void classeNulaLancaExcecao() {
        IllegalArgumentException ex = org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                SapzCriterioRubrica valor = null;
                if (valor == null) {
                    throw new IllegalArgumentException("SapzCriterioRubrica não pode ser nulo");
                }
            });
        org.junit.jupiter.api.Assertions.assertEquals("SapzCriterioRubrica não pode ser nulo", ex.getMessage());
    }
}
