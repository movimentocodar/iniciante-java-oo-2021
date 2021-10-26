package com.github.movimentocodar.maquinadecafe.maquinadecafe.reservatorio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AguaReservatorioTest {
    private AguaReservatorio aguaReservatorio = new AguaReservatorio(new CapacidadeReservatorio());

    @Test
    void verificaSeAguaInicialDoReservatorioE200() {
        assertEquals(200, aguaReservatorio.getAguaDoReservatorio());
    }

    @Test
    void verificarSeJogaExceptionCasoCapacidadeDoReservatorioForNegativa() {
        Exception e = assertThrows(Exception.class , () -> {
            AguaReservatorio aguaReservatorioInvalida = new AguaReservatorio(new CapacidadeReservatorio(-10));
        });
        assertTrue(e.getMessage().contains("Capacidade do Reservatorio não pode ser < ou = 0"));
    }

    @Test
    void abastecerAguaDoReservatorioCasoTenhaCapacidadeSuficiente() {
        aguaReservatorio.abastecer(200);
        assertEquals(400, aguaReservatorio.getAguaDoReservatorio());
    }

    @Test
    void abastecerAguaDoReservatorioCasoTenhaCapacidadeInsuficiente() {
        Exception e = assertThrows(Exception.class , () -> {
            aguaReservatorio.abastecer(1100);
        });
        assertTrue(e.getMessage().contains("Valor Invalido!"));
    }

    @Test
    void tentarAbastecerReservatorio2VezesComValorSuficiente() {
        aguaReservatorio.abastecer(200);
        aguaReservatorio.abastecer(200);
        assertEquals(600, aguaReservatorio.getAguaDoReservatorio());
    }

    @Test
    void tentarAbastecerReservatorio2VezesComCapacidadeInsuficiente() {
        Exception e = assertThrows(Exception.class , () -> {
            aguaReservatorio.abastecer(300);
            aguaReservatorio.abastecer(800);
        });
        assertTrue(e.getMessage().contains("Valor Invalido!"));
    }

    @Test
    void tentarAbastecerReservatorioComValorZero() {
        Exception e = assertThrows(Exception.class , () -> {
            aguaReservatorio.abastecer(0);
        });
        assertTrue(e.getMessage().contains("Valor Invalido!"));
    }

    @Test
    void tentarAbastecerReservatorioComValorNegativo() {
        Exception e = assertThrows(Exception.class , () -> {
            aguaReservatorio.abastecer(-10);
        });
        assertTrue(e.getMessage().contains("Valor Invalido!"));
    }

    @Test
    void verificarSeUsarAguaEUsadaCorretamenteComValorValido() {
        aguaReservatorio.usarAgua(50);
        assertEquals(150, aguaReservatorio.getAguaDoReservatorio());
    }

    @Test
    void verificarSeUsarAguaJogaExceptionComValorMaiorQueQuantidadeDisponivel() {
        Exception e = assertThrows(Exception.class , () -> {
            aguaReservatorio.abastecer(50);
            aguaReservatorio.usarAgua(300);
        });
        assertTrue(e.getMessage().contains("Valor Invalido"));
    }

    @Test
    void verificarSeUsarAguaJogaExceptionComValorNegativo() {
        Exception e = assertThrows(Exception.class , () -> {
            aguaReservatorio.abastecer(200);
            aguaReservatorio.usarAgua(-10);
        });
        assertTrue(e.getMessage().contains("Valor Invalido"));
    }

    @Test
    void verificarSeUsarAguaJogaExceptionComValorZero() {
        Exception e = assertThrows(Exception.class , () -> {
            aguaReservatorio.abastecer(200);
            aguaReservatorio.usarAgua(-10);
        });
        assertTrue(e.getMessage().contains("Valor Invalido"));
    }

    @Test
    void verificarSeAguaEsvaziaParaValorZero() {
        aguaReservatorio.abastecer(200);
        aguaReservatorio.esvaziarAgua();
        assertEquals(0, aguaReservatorio.getAguaDoReservatorio());
    }
}