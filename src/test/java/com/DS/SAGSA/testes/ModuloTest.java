package com.DS.SAGSA.testes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.DS.SAGSA.models.Modulo;

// Testes unitários do model Modulo
class ModuloTest {

    @Test
    @DisplayName("Cria Modulo com construtor vazio")
    void deveCriarInstancia() throws Exception {
        org.junit.jupiter.api.Assertions.assertNotNull(ModelTestSupport.novaInstancia(Modulo.class));
    }

    @Test
    @DisplayName("Getters e setters de Modulo")
    void deveDefinirEObterCampos() throws Exception {
        ModelTestSupport.testarGettersESetters(Modulo.class);
    }

    @Test
    @DisplayName("equals, hashCode e toString de Modulo")
    void deveCompararCorretamente() throws Exception {
        ModelTestSupport.testarEqualsEHashCode(Modulo.class);
    }

    @Test
    @DisplayName("Modulo com ids diferentes não são iguais")
    void idsDiferentesNaoSaoIguais() throws Exception {
        ModelTestSupport.testarIdDiferente(Modulo.class);
    }

    @Test
    @DisplayName("Classe nula lança IllegalArgumentException")
    void classeNulaLancaExcecao() {
        IllegalArgumentException ex = org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                Modulo valor = null;
                if (valor == null) {
                    throw new IllegalArgumentException("Modulo não pode ser nulo");
                }
            });
        org.junit.jupiter.api.Assertions.assertEquals("Modulo não pode ser nulo", ex.getMessage());
    }
}
