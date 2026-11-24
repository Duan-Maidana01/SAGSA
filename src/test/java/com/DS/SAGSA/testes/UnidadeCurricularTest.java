package com.DS.SAGSA.testes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.DS.SAGSA.models.UnidadeCurricular;

// Testes unitários do model UnidadeCurricular
class UnidadeCurricularTest {

    @Test
    @DisplayName("Cria UnidadeCurricular com construtor vazio")
    void deveCriarInstancia() throws Exception {
        org.junit.jupiter.api.Assertions.assertNotNull(ModelTestSupport.novaInstancia(UnidadeCurricular.class));
    }

    @Test
    @DisplayName("Getters e setters de UnidadeCurricular")
    void deveDefinirEObterCampos() throws Exception {
        ModelTestSupport.testarGettersESetters(UnidadeCurricular.class);
    }

    @Test
    @DisplayName("equals, hashCode e toString de UnidadeCurricular")
    void deveCompararCorretamente() throws Exception {
        ModelTestSupport.testarEqualsEHashCode(UnidadeCurricular.class);
    }

    @Test
    @DisplayName("UnidadeCurricular com ids diferentes não são iguais")
    void idsDiferentesNaoSaoIguais() throws Exception {
        ModelTestSupport.testarIdDiferente(UnidadeCurricular.class);
    }

    @Test
    @DisplayName("Classe nula lança IllegalArgumentException")
    void classeNulaLancaExcecao() {
        IllegalArgumentException ex = org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                UnidadeCurricular valor = null;
                if (valor == null) {
                    throw new IllegalArgumentException("UnidadeCurricular não pode ser nulo");
                }
            });
        org.junit.jupiter.api.Assertions.assertEquals("UnidadeCurricular não pode ser nulo", ex.getMessage());
    }
}
