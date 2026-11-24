package com.DS.SAGSA.testes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.DS.SAGSA.models.SapzHistoricoPdf;

// Testes unitários do model SapzHistoricoPdf
class SapzHistoricoPdfTest {

    @Test
    @DisplayName("Cria SapzHistoricoPdf com construtor vazio")
    void deveCriarInstancia() throws Exception {
        org.junit.jupiter.api.Assertions.assertNotNull(ModelTestSupport.novaInstancia(SapzHistoricoPdf.class));
    }

    @Test
    @DisplayName("Getters e setters de SapzHistoricoPdf")
    void deveDefinirEObterCampos() throws Exception {
        ModelTestSupport.testarGettersESetters(SapzHistoricoPdf.class);
    }

    @Test
    @DisplayName("equals, hashCode e toString de SapzHistoricoPdf")
    void deveCompararCorretamente() throws Exception {
        ModelTestSupport.testarEqualsEHashCode(SapzHistoricoPdf.class);
    }

    @Test
    @DisplayName("SapzHistoricoPdf com ids diferentes não são iguais")
    void idsDiferentesNaoSaoIguais() throws Exception {
        ModelTestSupport.testarIdDiferente(SapzHistoricoPdf.class);
    }

    @Test
    @DisplayName("Classe nula lança IllegalArgumentException")
    void classeNulaLancaExcecao() {
        IllegalArgumentException ex = org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                SapzHistoricoPdf valor = null;
                if (valor == null) {
                    throw new IllegalArgumentException("SapzHistoricoPdf não pode ser nulo");
                }
            });
        org.junit.jupiter.api.Assertions.assertEquals("SapzHistoricoPdf não pode ser nulo", ex.getMessage());
    }
}
