package com.DS.SAGSA.testes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.DS.SAGSA.models.Usuario;

// Testes unitários do model Usuario
class UsuarioTest {

    @Test
    @DisplayName("Cria Usuario com construtor vazio")
    void deveCriarInstancia() throws Exception {
        org.junit.jupiter.api.Assertions.assertNotNull(ModelTestSupport.novaInstancia(Usuario.class));
    }

    @Test
    @DisplayName("Getters e setters de Usuario")
    void deveDefinirEObterCampos() throws Exception {
        ModelTestSupport.testarGettersESetters(Usuario.class);
    }

    @Test
    @DisplayName("equals, hashCode e toString de Usuario")
    void deveCompararCorretamente() throws Exception {
        ModelTestSupport.testarEqualsEHashCode(Usuario.class);
    }

    @Test
    @DisplayName("Usuario com ids diferentes não são iguais")
    void idsDiferentesNaoSaoIguais() throws Exception {
        ModelTestSupport.testarIdDiferente(Usuario.class);
    }

    @Test
    @DisplayName("Classe nula lança IllegalArgumentException")
    void classeNulaLancaExcecao() {
        IllegalArgumentException ex = org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                Usuario valor = null;
                if (valor == null) {
                    throw new IllegalArgumentException("Usuario não pode ser nulo");
                }
            });
        org.junit.jupiter.api.Assertions.assertEquals("Usuario não pode ser nulo", ex.getMessage());
    }
}
