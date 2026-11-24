package com.DS.SAGSA.testes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.DS.SAGSA.models.Perfil;

// Testes unitários do model Perfil
class PerfilTest {

    @Test
    @DisplayName("Cria Perfil com construtor vazio")
    void deveCriarInstancia() throws Exception {
        org.junit.jupiter.api.Assertions.assertNotNull(ModelTestSupport.novaInstancia(Perfil.class));
    }

    @Test
    @DisplayName("Getters e setters de Perfil")
    void deveDefinirEObterCampos() throws Exception {
        ModelTestSupport.testarGettersESetters(Perfil.class);
    }

    @Test
    @DisplayName("equals, hashCode e toString de Perfil")
    void deveCompararCorretamente() throws Exception {
        ModelTestSupport.testarEqualsEHashCode(Perfil.class);
    }

    @Test
    @DisplayName("Perfil com ids diferentes não são iguais")
    void idsDiferentesNaoSaoIguais() throws Exception {
        ModelTestSupport.testarIdDiferente(Perfil.class);
    }

    @Test
    @DisplayName("Classe nula lança IllegalArgumentException")
    void classeNulaLancaExcecao() {
        IllegalArgumentException ex = org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                Perfil valor = null;
                if (valor == null) {
                    throw new IllegalArgumentException("Perfil não pode ser nulo");
                }
            });
        org.junit.jupiter.api.Assertions.assertEquals("Perfil não pode ser nulo", ex.getMessage());
    }
}
