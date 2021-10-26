package com.github.movimentocodar.maquinadecafe.maquinadecafe.bebidas;

import com.github.movimentocodar.maquinadecafe.maquinadecafe.bebidas.receitas.AguaQuente;
import com.github.movimentocodar.maquinadecafe.maquinadecafe.bebidas.receitas.BebidaImpl;
import com.github.movimentocodar.maquinadecafe.maquinadecafe.bebidas.receitas.Cafe;
import com.github.movimentocodar.maquinadecafe.maquinadecafe.creditos.FormaDePagamento;
import com.github.movimentocodar.maquinadecafe.maquinadecafe.creditos.GerenciadorCredito;
import com.github.movimentocodar.maquinadecafe.maquinadecafe.reservatorio.ReservatorioDeAgua;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class GerenciadorBebidaTest {

    GerenciadorBebida gerenciadorBebida = new GerenciadorBebida();
    ReservatorioDeAgua reservatorio = new ReservatorioDeAgua();
    GerenciadorCredito gerenciadorCredito = new GerenciadorCredito();

    @Test
    void prepararBebidaDeveRetornarSemErro() {
        reservatorio.abastecerReservatorio(200);
        gerenciadorCredito.adicionarCredito(new BigDecimal("200"), FormaDePagamento.DEBITO);
        gerenciadorBebida.prepararBebida(new Cafe(), reservatorio, gerenciadorCredito);
    }

    @Test
    void prepararBebidaSemAguaSuficienteDeveRetornarException() {
        gerenciadorCredito.adicionarCredito(new BigDecimal("200"), FormaDePagamento.DEBITO);
        Exception e = assertThrows(Exception.class , () -> {
            gerenciadorBebida.prepararBebida(new Cafe(), reservatorio, gerenciadorCredito);
        });
        assertTrue(e.getMessage().contains("Agua Insuficiente"));
    }

    @Test
    void prepararBebidaSemDinheiroSuficienteDeveRetornarException() {
        reservatorio.abastecerReservatorio(200);
        Exception e = assertThrows(Exception.class , () -> {
            gerenciadorBebida.prepararBebida(new Cafe(), reservatorio, gerenciadorCredito);
        });
        assertTrue(e.getMessage().contains("Credito insuficiente ou invalido!"));
    }

    @Test
    void verificarSeEstaPreparandoBebidasDeGraca() {
        reservatorio.abastecerReservatorio(200);
        gerenciadorBebida.prepararBebida(new AguaQuente(), reservatorio, gerenciadorCredito);
        assertDoesNotThrow(() -> gerenciadorBebida);
    }

}