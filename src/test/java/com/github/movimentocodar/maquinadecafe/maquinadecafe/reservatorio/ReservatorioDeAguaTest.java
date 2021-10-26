package com.github.movimentocodar.maquinadecafe.maquinadecafe.reservatorio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservatorioDeAguaTest {
    ReservatorioDeAgua reservatorioDeAgua = new ReservatorioDeAgua();
    @Test
    void capacidadeDe1000ReservatorioPadrao() {
        assertEquals(1000, reservatorioDeAgua.getCapacidadeDoReservatorio());
    }

    @Test
    void aguaInicial200ReservatorioPadrao() {
        assertEquals(200, reservatorioDeAgua.getAguaDoReservatorio());
    }

    @Test
    void mudarCapacidadeValidaReservatorioPadrao() {
        reservatorioDeAgua.mudarCapacidadeDoReservatorio(2000);
        assertEquals(2000, reservatorioDeAgua.getCapacidadeDoReservatorio());
    }

    @Test
    void verificarSeAguaDoReservatorioPadraoEEsvaziadaQuandoMudaReservatorio() {
        reservatorioDeAgua.abastecerReservatorio(200);
        reservatorioDeAgua.mudarCapacidadeDoReservatorio(2000);
        assertEquals(0, reservatorioDeAgua.getAguaDoReservatorio());
    }

    @Test
    void verificarSeDaPraAbastecerValorModificadoCorretamente() {
        reservatorioDeAgua.mudarCapacidadeDoReservatorio(2000);
        reservatorioDeAgua.abastecerReservatorio(1500);
        assertEquals(1500, reservatorioDeAgua.getAguaDoReservatorio());
    }

    @Test
    void verificarSeJogaExceptionCasoCapacidadeForNegativa() {
        try {
            reservatorioDeAgua.mudarCapacidadeDoReservatorio(-200);
            fail("Exception não foi jogada");
        } catch (Exception e) {
            assertEquals("Capacidade do Reservatorio não pode ser < ou = 0", e.getMessage());
        }
    }

    @Test
    void verificarSeJogaExceptionCasoCapacidadeForZero() {
        try {
            reservatorioDeAgua.mudarCapacidadeDoReservatorio(0);
            fail("Exception não foi jogada");
        } catch (Exception e) {
            assertEquals("Capacidade do Reservatorio não pode ser < ou = 0", e.getMessage());
        }
    }

    @Test
    void verificaSeUsaAguaCorretamenteCasoValoresSejamValidos() {
        reservatorioDeAgua.usarAgua(50);
        assertEquals(150, reservatorioDeAgua.getAguaDoReservatorio());
    }

    @Test
    void verificaSeJogaExceptionNoUsarAguaCasoValorForNegativo() {
        try {
            reservatorioDeAgua.abastecerReservatorio(200);
            reservatorioDeAgua.usarAgua(-50);
            fail("Não Jogou Exception");
        } catch (Exception e) {
            assertEquals("Valor Invalido", e.getMessage());
        }
    }

    @Test
    void verificaSeJogaExceptionNoUsarAguaCasoValorForZero() {
        try {
            reservatorioDeAgua.abastecerReservatorio(200);
            reservatorioDeAgua.usarAgua(0);
            fail("Não Jogou Exception");
        } catch (Exception e) {
            assertEquals("Valor Invalido", e.getMessage());
        }
    }

    @Test
    void verificaSeJogaExceptionCasoAbastecerForMaiorQueCapacidade() {
        try {
            reservatorioDeAgua.mudarCapacidadeDoReservatorio(100);
            reservatorioDeAgua.abastecerReservatorio(200);
            fail("Não Jogou Exception");
        } catch (Exception e) {
            assertEquals("Valor Invalido!", e.getMessage());
        }
    }

    @Test
    void verificaSeJogaExceptionCasoAbastecerForNegativo() {
        try {
            reservatorioDeAgua.mudarCapacidadeDoReservatorio(100);
            reservatorioDeAgua.abastecerReservatorio(-10);
            fail("Não Jogou Exception");
        } catch (Exception e) {
            assertEquals("Valor Invalido!", e.getMessage());
        }
    }

    @Test
    void verificarSeJogaExceptionCasoCapacidadeForNegativaNoConstrutor() {
        try {
            ReservatorioDeAgua reservatorioDeAguaComCapacidadeCustomizada = new ReservatorioDeAgua(-500);
            fail("Não Jogou Exception!");
        } catch (Exception e) {
            assertEquals("Capacidade do Reservatorio não pode ser < ou = 0", e.getMessage());
        }
    }

    @Test
    void verificarSeJogaExceptionCasoCapacidadeForZeroNoConstrutor() {
        try {
            ReservatorioDeAgua reservatorioDeAguaComCapacidadeCustomizada = new ReservatorioDeAgua(0);
            fail("Não Jogou Exception!");
        } catch (Exception e) {
            assertEquals("Capacidade do Reservatorio não pode ser < ou = 0", e.getMessage());
        }
    }

    @Test
    void verificarSeJogaExceptionCasoQuantidadeDeAguaForMaiorQueCapacidadeNoConstrutor() {
        try {
            ReservatorioDeAgua reservatorioDeAguaComCapacidadeCustomizada = new ReservatorioDeAgua(500, 1000);
            fail("Não Jogou Exception!");
        } catch (Exception e) {
            assertEquals("Valor Invalido!", e.getMessage());
        }
    }

    @Test
    void verificarSeJogaExceptionCasoQuantidadeDeAguaForNegativoNoConstrutor() {
        try {
            ReservatorioDeAgua reservatorioDeAguaComCapacidadeCustomizada = new ReservatorioDeAgua(500, -10);
            fail("Não Jogou Exception!");
        } catch (Exception e) {
            assertEquals("Valor Invalido!", e.getMessage());
        }
    }

    @Test
    void verificarSeLitrosDeAguaInicialEDefinidoCorretamente() {
        ReservatorioDeAgua reservatorioDeAguaComCapacidadeCustomizada = new ReservatorioDeAgua(5000, 5000);
        assertEquals(5000, reservatorioDeAguaComCapacidadeCustomizada.getAguaDoReservatorio());
    }

}