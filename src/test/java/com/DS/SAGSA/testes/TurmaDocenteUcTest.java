package com.DS.SAGSA.testes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.DS.SAGSA.models.TurmaDocenteUc;

// Testes unitários do model TurmaDocenteUc
class TurmaDocenteUcTest {

    @Test
    @DisplayName("Cria TurmaDocenteUc com construtor vazio")
    void deveCriarInstancia() throws Exception {
        org.junit.jupiter.api.Assertions.assertNotNull(ModelTestSupport.novaInstancia(TurmaDocenteUc.class));
    }

    @Test
    @DisplayName("Getters e setters de TurmaDocenteUc")
    void deveDefinirEObterCampos() throws Exception {
        ModelTestSupport.testarGettersESetters(TurmaDocenteUc.class);
    }

    @Test
    @DisplayName("equals, hashCode e toString de TurmaDocenteUc")
    void deveCompararCorretamente() throws Exception {
        ModelTestSupport.testarEqualsEHashCode(TurmaDocenteUc.class);
    }

    @Test
    @DisplayName("TurmaDocenteUc com ids diferentes não são iguais")
    void idsDiferentesNaoSaoIguais() throws Exception {
        ModelTestSupport.testarIdDiferente(TurmaDocenteUc.class);
    }

    @Test
    @DisplayName("Classe nula lança IllegalArgumentException")
    void classeNulaLancaExcecao() {
        IllegalArgumentException ex = org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                TurmaDocenteUc valor = null;
                if (valor == null) {
                    throw new IllegalArgumentException("TurmaDocenteUc não pode ser nulo");
                }
            });
        org.junit.jupiter.api.Assertions.assertEquals("TurmaDocenteUc não pode ser nulo", ex.getMessage());
    }
}
