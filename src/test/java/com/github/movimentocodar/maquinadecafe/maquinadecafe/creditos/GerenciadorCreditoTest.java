package com.github.movimentocodar.maquinadecafe.maquinadecafe.creditos;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GerenciadorCreditoTest {
    GerenciadorCredito gerenciadorCredito = new GerenciadorCredito();

    @Test
    void testarAdicionarCreditoCedulaValido() {
        List<BigDecimal> notasValidas;
        notasValidas = Arrays.asList(
                new BigDecimal("2"),
                new BigDecimal("5"),
                new BigDecimal("10"),
                new BigDecimal("20"),
                new BigDecimal("50"),
                new BigDecimal("100"),
                new BigDecimal("200"));

        for (int i = 0; i < notasValidas.size(); i++) {
            gerenciadorCredito.adicionarCredito(notasValidas.get(i), FormaDePagamento.CEDULA);
        }
        assertDoesNotThrow(() -> gerenciadorCredito);
    }

    @Test
    void testarAdicionarCreditoCedulaInvalidaPositiva() {
        Exception e = assertThrows(Exception.class , () -> {
            gerenciadorCredito.adicionarCredito(new BigDecimal("3"), FormaDePagamento.CEDULA);
        });
        assertTrue(e.getMessage().contains("Forma de Pagamento Invalida!"));
    }

    @Test
    void testarAdicionarCreditoCedulaInvalidaNumeroNegativo() {
        Exception e = assertThrows(Exception.class , () -> {
            gerenciadorCredito.adicionarCredito(new BigDecimal("-3"), FormaDePagamento.CEDULA);
        });
        assertTrue(e.getMessage().contains("valorCredito não pode ser <=0"));
    }

    @Test
    void jogarExceptionCreditoComValorZero() {
        Exception e = assertThrows(Exception.class , () -> {
            gerenciadorCredito.adicionarCredito(new BigDecimal("0"), FormaDePagamento.DEBITO);
        });
        assertTrue(e.getMessage().contains("valorCredito não pode ser <=0"));
    }

    @Test
    void jogarExceptionCreditoComValorNegativo() {
        Exception e = assertThrows(Exception.class , () -> {
            gerenciadorCredito.adicionarCredito(new BigDecimal("-1"), FormaDePagamento.DEBITO);
        });
        assertTrue(e.getMessage().contains("valorCredito não pode ser <=0"));
    }

    @Test
    void testarSacarCredito() {
        gerenciadorCredito.adicionarCredito(new BigDecimal("20"), FormaDePagamento.DEBITO);
        gerenciadorCredito.sacarCredito(new BigDecimal("10"));
        BigDecimal creditosAtuais = gerenciadorCredito.getCreditos();
        assertEquals(new BigDecimal("10"), creditosAtuais);
    }

    @Test
    void jogarExceptionSacarCreditoComValorZero() {
        Exception e = assertThrows(Exception.class , () -> {
            gerenciadorCredito.adicionarCredito(new BigDecimal("20"), FormaDePagamento.DEBITO);
            gerenciadorCredito.sacarCredito(new BigDecimal("0"));
        });
        assertTrue(e.getMessage().contains("valorCredito não pode ser <=0"));
    }

    @Test
    void jogarExceptionSacarCreditoComValorNegativo() {
        Exception e = assertThrows(Exception.class , () -> {
            gerenciadorCredito.adicionarCredito(new BigDecimal("20"), FormaDePagamento.DEBITO);
            gerenciadorCredito.sacarCredito(new BigDecimal("-1"));
        });
        assertTrue(e.getMessage().contains("valorCredito não pode ser <=0"));
    }
}