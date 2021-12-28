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
        Exception e = assertThrows(Exception.class , () -> {
            capacidadeReservatorio.setCapacidade(0);
        });
        assertTrue(e.getMessage().contains("Capacidade do Reservatorio não pode ser < ou = 0"));
    }

    @Test
    void setCapacidadeCasoValorForMenorQueZero() {
        Exception e = assertThrows(Exception.class , () -> {
            capacidadeReservatorio.setCapacidade(-200);
        });
        assertTrue(e.getMessage().contains("Capacidade do Reservatorio não pode ser < ou = 0"));
    }
}