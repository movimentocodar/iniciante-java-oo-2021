package com.jands.cafefx.maquinadecafe.model.credito;

import com.jands.cafefx.maquinadecafe.model.bebida.receitas.AguaQuente;
import com.jands.cafefx.maquinadecafe.model.bebida.receitas.IBebida;
import com.jands.cafefx.maquinadecafe.model.credito.creditavel.Cedulas;
import com.jands.cafefx.maquinadecafe.model.credito.creditavel.Debito;
import com.jands.cafefx.maquinadecafe.model.credito.creditavel.ICreditavel;
import com.jands.cafefx.maquinadecafe.model.credito.modelocredito.AdicionarCreditoNaMaquina;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.*;

class GerenciadorDeCreditoTest {
    private double valor;

    @Test
    void VerificaAdicionarCedulaNumeroPositivoComNotasValidas() {
        List<Double> notas = List.of(2.00, 5.00, 10.00, 20.00, 50.00, 100.00, 200.00);
        ICreditavel cedulas = new Cedulas();
        GerenciadorDeCredito.adicionarCredito(cedulas, notas.get(0));
        try {
            for (int i = 0; i < notas.size(); i++) {
                assertEquals(notas.get(i), AdicionarCreditoNaMaquina.adicionar(cedulas, notas.get(i)));
            }
        } catch (Exception e) {
            fail("Alguma nota na classe cedula não adicionada como valida!");
        }
    }

    @Test
    void VerificaAdicionarCedulaSeONumeroForNegativoJogarException() {
        ICreditavel cedulas = new Cedulas();
        try {
            GerenciadorDeCredito.adicionarCredito(cedulas, -10);
            fail("A Exception não foi Jogada!");
        } catch (Exception e) {
            assertEquals(e.getMessage(), e);
        }
    }

    @Test
    void VerificaAdicionarDebitoNumeroPositivoValido() {
        ICreditavel debito = new Debito();
        assertEquals(10, GerenciadorDeCredito.adicionarCredito(debito, 10));
    }

    @Test
    void VerificaAdicionarDebitoSeONumeroForNegativoJogarException() {
        ICreditavel debito = new Debito();
        try {
            GerenciadorDeCredito.adicionarCredito(debito, -10);
            fail("A Exception não foi Jogada!");
        } catch (Exception e) {
            assertEquals(e, e);
        }
    }

    @Test
    void SacarCreditoAtualDaMaquinaComValorPositivoValido() {
        double creditoDaMaquina = 10;
        GerenciadorDeCredito.sacarCredito(creditoDaMaquina, 9);
        assertEquals(1, creditoDaMaquina);
    }

    @Test
    void SacarCreditoAtualDaMaquinaComValorIgualValido() {
        double creditoDaMaquina = 10;
        GerenciadorDeCredito.sacarCredito(creditoDaMaquina, 10);
        assertEquals(0, creditoDaMaquina);
    }

    @Test
    void SacarCreditoAtualDaMaquinaComValorMaiorQueCreditoDaMaquina() {
        double creditoDaMaquina = 10;
        try {
            GerenciadorDeCredito.sacarCredito(creditoDaMaquina, 11);
            fail("A Exception não foi Jogada!");
        } catch (Exception e) {
            assertEquals(e, e);
        }
    }

    @Test
    void SacarCreditoAtualDaMaquinaComValorNegativo() {
        double creditoDaMaquina = 10;
        try {
            GerenciadorDeCredito.sacarCredito(creditoDaMaquina, -1);
            fail("A Exception não foi Jogada!");
        } catch (Exception e) {
            assertEquals(e, e);
        }
    }


}