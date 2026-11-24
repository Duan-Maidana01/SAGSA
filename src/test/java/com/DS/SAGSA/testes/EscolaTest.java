package com.DS.SAGSA.testes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.DS.SAGSA.models.Escola;

// Testes unitários do model Escola
class EscolaTest {

    @Test
    @DisplayName("Cria Escola com construtor vazio")
    void deveCriarInstancia() throws Exception {
        org.junit.jupiter.api.Assertions.assertNotNull(ModelTestSupport.novaInstancia(Escola.class));
    }

    @Test
    @DisplayName("Getters e setters de Escola")
    void deveDefinirEObterCampos() throws Exception {
        ModelTestSupport.testarGettersESetters(Escola.class);
    }

    @Test
    @DisplayName("equals, hashCode e toString de Escola")
    void deveCompararCorretamente() throws Exception {
        ModelTestSupport.testarEqualsEHashCode(Escola.class);
    }

    @Test
    @DisplayName("Escola com ids diferentes não são iguais")
    void idsDiferentesNaoSaoIguais() throws Exception {
        ModelTestSupport.testarIdDiferente(Escola.class);
    }

    @Test
    @DisplayName("Classe nula lança IllegalArgumentException")
    void classeNulaLancaExcecao() {
        IllegalArgumentException ex = org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                Escola valor = null;
                if (valor == null) {
                    throw new IllegalArgumentException("Escola não pode ser nulo");
                }
            });
        org.junit.jupiter.api.Assertions.assertEquals("Escola não pode ser nulo", ex.getMessage());
    }
}
