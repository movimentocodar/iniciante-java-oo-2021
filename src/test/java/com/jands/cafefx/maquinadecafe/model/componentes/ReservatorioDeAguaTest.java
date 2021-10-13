package com.jands.cafefx.maquinadecafe.model.componentes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservatorioDeAguaTest {

    @Test
    void usarAguaCasoTenhaAguaSuficiente() {
        ReservatorioDeAgua.usarAgua(50);
        assertEquals(0, ReservatorioDeAgua.getAguaReservatorio());
    }

    @Test
    void abastecerAgua() {
        ReservatorioDeAgua.abastercerAgua(200);
        assertEquals(200, ReservatorioDeAgua.getAguaReservatorio());
    }

    @Test
    void abastercerAguaNegativo() {
        try {
            ReservatorioDeAgua.abastercerAgua(-200);
            fail("A Exception não foi Jogada!");
        } catch (Exception e) {
            assertEquals("Não pode abastecer com valor negativo", e);
        }
    }

    @Test
    void abastercerAguaAcimaDoLimeteDe1Litro() {
        try {
            ReservatorioDeAgua.abastercerAgua(1000);
            fail("A Exception não foi Jogada!");
        } catch (Exception e) {
            assertEquals("Não pode abastecer com valor negativo", e);
        }
    }
}