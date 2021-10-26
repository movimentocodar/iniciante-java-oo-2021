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
        Exception e = assertThrows(Exception.class , () -> {
            reservatorioDeAgua.mudarCapacidadeDoReservatorio(-200);
        });
        assertTrue(e.getMessage().contains("Capacidade do Reservatorio não pode ser < ou = 0"));
    }

    @Test
    void verificarSeJogaExceptionCasoCapacidadeForZero() {
        Exception e = assertThrows(Exception.class , () -> {
            reservatorioDeAgua.mudarCapacidadeDoReservatorio(0);
        });
        assertTrue(e.getMessage().contains("Capacidade do Reservatorio não pode ser < ou = 0"));
    }

    @Test
    void verificaSeUsaAguaCorretamenteCasoValoresSejamValidos() {
        reservatorioDeAgua.usarAgua(50);
        assertEquals(150, reservatorioDeAgua.getAguaDoReservatorio());
    }

    @Test
    void verificaSeJogaExceptionNoUsarAguaCasoValorForNegativo() {
        Exception e = assertThrows(Exception.class , () -> {
            reservatorioDeAgua.abastecerReservatorio(200);
            reservatorioDeAgua.usarAgua(-50);
        });
        assertTrue(e.getMessage().contains("Valor Invalido"));
    }

    @Test
    void verificaSeJogaExceptionNoUsarAguaCasoValorForZero() {
        Exception e = assertThrows(Exception.class , () -> {
            reservatorioDeAgua.abastecerReservatorio(200);
            reservatorioDeAgua.usarAgua(0);
        });
        assertTrue(e.getMessage().contains("Valor Invalido"));
    }

    @Test
    void verificaSeJogaExceptionCasoAbastecerForMaiorQueCapacidade() {
        Exception e = assertThrows(Exception.class , () -> {
            reservatorioDeAgua.mudarCapacidadeDoReservatorio(100);
            reservatorioDeAgua.abastecerReservatorio(200);
        });
        assertTrue(e.getMessage().contains("Valor Invalido"));
    }

    @Test
    void verificaSeJogaExceptionCasoAbastecerForNegativo() {
        Exception e = assertThrows(Exception.class , () -> {
            reservatorioDeAgua.mudarCapacidadeDoReservatorio(100);
            reservatorioDeAgua.abastecerReservatorio(-10);
        });
        assertTrue(e.getMessage().contains("Valor Invalido"));
    }

    @Test
    void verificarSeJogaExceptionCasoCapacidadeForNegativaNoConstrutor() {
        Exception e = assertThrows(Exception.class , () -> {
            ReservatorioDeAgua reservatorioDeAguaComCapacidadeCustomizada = new ReservatorioDeAgua(-500);
        });
        assertTrue(e.getMessage().contains("Capacidade do Reservatorio não pode ser < ou = 0"));
    }

    @Test
    void verificarSeJogaExceptionCasoCapacidadeForZeroNoConstrutor() {
        Exception e = assertThrows(Exception.class , () -> {
            ReservatorioDeAgua reservatorioDeAguaComCapacidadeCustomizada = new ReservatorioDeAgua(0);
        });
        assertTrue(e.getMessage().contains("Capacidade do Reservatorio não pode ser < ou = 0"));
    }

    @Test
    void verificarSeJogaExceptionCasoQuantidadeDeAguaForMaiorQueCapacidadeNoConstrutor() {
        Exception e = assertThrows(Exception.class , () -> {
            ReservatorioDeAgua reservatorioDeAguaComCapacidadeCustomizada = new ReservatorioDeAgua(500, 1000);
        });
        assertTrue(e.getMessage().contains("Valor Invalido!"));
    }

    @Test
    void verificarSeJogaExceptionCasoQuantidadeDeAguaForNegativoNoConstrutor() {
        Exception e = assertThrows(Exception.class , () -> {
            ReservatorioDeAgua reservatorioDeAguaComCapacidadeCustomizada = new ReservatorioDeAgua(500, -10);
        });
        assertTrue(e.getMessage().contains("Valor Invalido!"));
    }

    @Test
    void verificarSeLitrosDeAguaInicialEDefinidoCorretamente() {
        ReservatorioDeAgua reservatorioDeAguaComCapacidadeCustomizada = new ReservatorioDeAgua(5000, 5000);
        assertEquals(5000, reservatorioDeAguaComCapacidadeCustomizada.getAguaDoReservatorio());
    }

}