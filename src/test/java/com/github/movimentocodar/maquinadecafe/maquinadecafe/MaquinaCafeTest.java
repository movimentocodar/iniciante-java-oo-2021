package com.github.movimentocodar.maquinadecafe.maquinadecafe;

import com.github.movimentocodar.maquinadecafe.maquinadecafe.bebidas.receitas.AguaQuente;
import com.github.movimentocodar.maquinadecafe.maquinadecafe.bebidas.receitas.Cafe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaquinaCafeTest {
    MaquinaCafe maquinadecafe = new MaquinaCafe();

    @Test
    void prepararBebidaMaquinaTest() throws Exception {
        boolean preparar = maquinadecafe.comprarBebida(new AguaQuente());
        assertEquals(true, preparar);
    }

    @Test
    void prepararBebidaJogarExeceptionCasoNaoTenhaAguaMaquinaTest() throws Exception {
        Exception e = assertThrows(Exception.class , () -> {
            for (int i = 0; i < 10; i++) {
                maquinadecafe.comprarBebida(new AguaQuente());
            }
        });
        assertTrue(e.getMessage().contains("Agua Insuficiente"));
    }

    @Test
    void prepararBebidaJogarExeceptionCasoNaoTenhaCreditoNaMaquinaTest() throws Exception {
        Exception e = assertThrows(Exception.class , () -> {
            maquinadecafe.comprarBebida(new Cafe());
        });
        assertTrue(e.getMessage().contains("Credito insuficiente ou invalido!"));
    }
}