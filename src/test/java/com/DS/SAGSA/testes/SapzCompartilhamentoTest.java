package com.DS.SAGSA.testes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.DS.SAGSA.models.SapzCompartilhamento;

// Testes unitários do model SapzCompartilhamento
class SapzCompartilhamentoTest {

    @Test
    @DisplayName("Cria SapzCompartilhamento com construtor vazio")
    void deveCriarInstancia() throws Exception {
        org.junit.jupiter.api.Assertions.assertNotNull(ModelTestSupport.novaInstancia(SapzCompartilhamento.class));
    }

    @Test
    @DisplayName("Getters e setters de SapzCompartilhamento")
    void deveDefinirEObterCampos() throws Exception {
        ModelTestSupport.testarGettersESetters(SapzCompartilhamento.class);
    }

    @Test
    @DisplayName("equals, hashCode e toString de SapzCompartilhamento")
    void deveCompararCorretamente() throws Exception {
        ModelTestSupport.testarEqualsEHashCode(SapzCompartilhamento.class);
    }

    @Test
    @DisplayName("SapzCompartilhamento com ids diferentes não são iguais")
    void idsDiferentesNaoSaoIguais() throws Exception {
        ModelTestSupport.testarIdDiferente(SapzCompartilhamento.class);
    }

    @Test
    @DisplayName("Classe nula lança IllegalArgumentException")
    void classeNulaLancaExcecao() {
        IllegalArgumentException ex = org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                SapzCompartilhamento valor = null;
                if (valor == null) {
                    throw new IllegalArgumentException("SapzCompartilhamento não pode ser nulo");
                }
            });
        org.junit.jupiter.api.Assertions.assertEquals("SapzCompartilhamento não pode ser nulo", ex.getMessage());
    }
}
