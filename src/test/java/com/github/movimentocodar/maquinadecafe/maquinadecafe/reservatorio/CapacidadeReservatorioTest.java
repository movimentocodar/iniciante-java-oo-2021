package com.github.movimentocodar.maquinadecafe.maquinadecafe.reservatorio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CapacidadeReservatorioTest {

    CapacidadeReservatorio capacidadeReservatorio = new CapacidadeReservatorio();

    @Test
    void verificarSeCapacidadePadraoE1000() {
        assertEquals(1000, capacidadeReservatorio.getCapacidade());
    }

    @Test
    void setCapacidadeCasoValorForMaiorQueZero() {
        capacidadeReservatorio.setCapacidade(200);
        assertEquals(200, capacidadeReservatorio.getCapacidade());
    }

    @Test
    void setCapacidadeCasoValorForIgualAZero() {
        try {
            capacidadeReservatorio.setCapacidade(0);
            fail("Não jogou uma Exception!");
        } catch (Exception e) {
            assertEquals("Capacidade do Reservatorio não pode ser < ou = 0", e.getMessage());
        }
    }

    @Test
    void setCapacidadeCasoValorForMenorQueZero() {
        try {
            capacidadeReservatorio.setCapacidade(-200);
            fail("Não jogou uma Exception!");
        } catch (Exception e) {
            assertEquals("Capacidade do Reservatorio não pode ser < ou = 0", e.getMessage());
        }
    }

}