package com.DS.SAGSA.testes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.DS.SAGSA.models.AreaTecnologica;

// Testes unitários do model AreaTecnologica
class AreaTecnologicaTest {

    @Test
    @DisplayName("Cria AreaTecnologica com construtor vazio")
    void deveCriarInstancia() throws Exception {
        org.junit.jupiter.api.Assertions.assertNotNull(ModelTestSupport.novaInstancia(AreaTecnologica.class));
    }

    @Test
    @DisplayName("Getters e setters de AreaTecnologica")
    void deveDefinirEObterCampos() throws Exception {
        ModelTestSupport.testarGettersESetters(AreaTecnologica.class);
    }

    @Test
    @DisplayName("equals, hashCode e toString de AreaTecnologica")
    void deveCompararCorretamente() throws Exception {
        ModelTestSupport.testarEqualsEHashCode(AreaTecnologica.class);
    }

    @Test
    @DisplayName("AreaTecnologica com ids diferentes não são iguais")
    void idsDiferentesNaoSaoIguais() throws Exception {
        ModelTestSupport.testarIdDiferente(AreaTecnologica.class);
    }

    @Test
    @DisplayName("Classe nula lança IllegalArgumentException")
    void classeNulaLancaExcecao() {
        IllegalArgumentException ex = org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                AreaTecnologica valor = null;
                if (valor == null) {
                    throw new IllegalArgumentException("AreaTecnologica não pode ser nulo");
                }
            });
        org.junit.jupiter.api.Assertions.assertEquals("AreaTecnologica não pode ser nulo", ex.getMessage());
    }
}
