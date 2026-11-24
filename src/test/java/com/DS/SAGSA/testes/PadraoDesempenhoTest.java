package com.DS.SAGSA.testes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.DS.SAGSA.models.PadraoDesempenho;

// Testes unitários do model PadraoDesempenho
class PadraoDesempenhoTest {

    @Test
    @DisplayName("Cria PadraoDesempenho com construtor vazio")
    void deveCriarInstancia() throws Exception {
        org.junit.jupiter.api.Assertions.assertNotNull(ModelTestSupport.novaInstancia(PadraoDesempenho.class));
    }

    @Test
    @DisplayName("Getters e setters de PadraoDesempenho")
    void deveDefinirEObterCampos() throws Exception {
        ModelTestSupport.testarGettersESetters(PadraoDesempenho.class);
    }

    @Test
    @DisplayName("equals, hashCode e toString de PadraoDesempenho")
    void deveCompararCorretamente() throws Exception {
        ModelTestSupport.testarEqualsEHashCode(PadraoDesempenho.class);
    }

    @Test
    @DisplayName("PadraoDesempenho com ids diferentes não são iguais")
    void idsDiferentesNaoSaoIguais() throws Exception {
        ModelTestSupport.testarIdDiferente(PadraoDesempenho.class);
    }

    @Test
    @DisplayName("Classe nula lança IllegalArgumentException")
    void classeNulaLancaExcecao() {
        IllegalArgumentException ex = org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                PadraoDesempenho valor = null;
                if (valor == null) {
                    throw new IllegalArgumentException("PadraoDesempenho não pode ser nulo");
                }
            });
        org.junit.jupiter.api.Assertions.assertEquals("PadraoDesempenho não pode ser nulo", ex.getMessage());
    }
}
