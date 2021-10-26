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
        try {
            AguaReservatorio aguaReservatorioInvalida = new AguaReservatorio(new CapacidadeReservatorio(-10));
            fail("Exemption não foi jogada");
        } catch (Exception e) {
            assertEquals("Capacidade do Reservatorio não pode ser < ou = 0", e.getMessage());
        }
    }

    @Test
    void abastecerAguaDoReservatorioCasoTenhaCapacidadeSuficiente() {
        aguaReservatorio.abastecer(200);
        assertEquals(400, aguaReservatorio.getAguaDoReservatorio());
    }

    @Test
    void abastecerAguaDoReservatorioCasoTenhaCapacidadeInsuficiente() {
        try {
            aguaReservatorio.abastecer(1100);
            fail("Não jogou a Exception");
        } catch (Exception e) {
            assertEquals("Valor Invalido!", e.getMessage());
        }
    }

    @Test
    void tentarAbastecerReservatorio2VezesComValorSuficiente() {
        aguaReservatorio.abastecer(200);
        aguaReservatorio.abastecer(200);
        assertEquals(600, aguaReservatorio.getAguaDoReservatorio());
    }

    @Test
    void tentarAbastecerReservatorio2VezesComCapacidadeInsuficiente() {
        try {
            aguaReservatorio.abastecer(300);
            aguaReservatorio.abastecer(800);
            fail("Não jogou a Exception");
        } catch (Exception e) {
            assertEquals("Valor Invalido!", e.getMessage());
        }
    }

    @Test
    void tentarAbastecerReservatorioComValorZero() {
        try {
            aguaReservatorio.abastecer(0);
            fail("Não jogou a Exception");
        } catch (Exception e) {
            assertEquals("Valor Invalido!", e.getMessage());
        }
    }

    @Test
    void tentarAbastecerReservatorioComValorNegativo() {
        try {
            aguaReservatorio.abastecer(-10);
            fail("Não jogou a Exception");
        } catch (Exception e) {
            assertEquals("Valor Invalido!", e.getMessage());
        }
    }

    @Test
    void verificarSeUsarAguaEUsadaCorretamenteComValorValido() {
        aguaReservatorio.usarAgua(50);
        assertEquals(150, aguaReservatorio.getAguaDoReservatorio());
    }

    @Test
    void verificarSeUsarAguaJogaExceptionComValorMaiorQueQuantidadeDisponivel() {
        try {
            aguaReservatorio.abastecer(50);
            aguaReservatorio.usarAgua(300);
            fail("Exception não foi jogada");
        } catch (Exception e) {
            assertEquals("Valor Invalido", e.getMessage());
        }
    }

    @Test
    void verificarSeUsarAguaJogaExceptionComValorNegativo() {
        try {
            aguaReservatorio.abastecer(200);
            aguaReservatorio.usarAgua(-10);
            fail("Exception não foi jogada");
        } catch (Exception e) {
            assertEquals("Valor Invalido", e.getMessage());
        }
    }

    @Test
    void verificarSeUsarAguaJogaExceptionComValorZero() {
        try {
            aguaReservatorio.abastecer(200);
            aguaReservatorio.usarAgua(0);
            fail("Exception não foi jogada");
        } catch (Exception e) {
            assertEquals("Valor Invalido", e.getMessage());
        }
    }

    @Test
    void verificarSeAguaEsvaziaParaValorZero() {
        aguaReservatorio.abastecer(200);
        aguaReservatorio.esvaziarAgua();
        assertEquals(0, aguaReservatorio.getAguaDoReservatorio());
    }
}