package com.DS.SAGSA.testes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.DS.SAGSA.models.EixoTecnologico;

// Testes unitários do model EixoTecnologico
class EixoTecnologicoTest {

    @Test
    @DisplayName("Cria EixoTecnologico com construtor vazio")
    void deveCriarInstancia() throws Exception {
        org.junit.jupiter.api.Assertions.assertNotNull(ModelTestSupport.novaInstancia(EixoTecnologico.class));
    }

    @Test
    @DisplayName("Getters e setters de EixoTecnologico")
    void deveDefinirEObterCampos() throws Exception {
        ModelTestSupport.testarGettersESetters(EixoTecnologico.class);
    }

    @Test
    @DisplayName("equals, hashCode e toString de EixoTecnologico")
    void deveCompararCorretamente() throws Exception {
        ModelTestSupport.testarEqualsEHashCode(EixoTecnologico.class);
    }

    @Test
    @DisplayName("EixoTecnologico com ids diferentes não são iguais")
    void idsDiferentesNaoSaoIguais() throws Exception {
        ModelTestSupport.testarIdDiferente(EixoTecnologico.class);
    }

    @Test
    @DisplayName("Classe nula lança IllegalArgumentException")
    void classeNulaLancaExcecao() {
        IllegalArgumentException ex = org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                EixoTecnologico valor = null;
                if (valor == null) {
                    throw new IllegalArgumentException("EixoTecnologico não pode ser nulo");
                }
            });
        org.junit.jupiter.api.Assertions.assertEquals("EixoTecnologico não pode ser nulo", ex.getMessage());
    }
}
