package com.jands.cafefx.maquinadecafe.model.bebida;

import com.jands.cafefx.maquinadecafe.model.MaquinaDeCafe;
import com.jands.cafefx.maquinadecafe.model.bebida.receitas.AguaQuente;
import com.jands.cafefx.maquinadecafe.model.bebida.receitas.Capuccino;
import com.jands.cafefx.maquinadecafe.model.bebida.receitas.IBebida;
import com.jands.cafefx.maquinadecafe.model.componentes.ReservatorioDeAgua;
import com.jands.cafefx.maquinadecafe.model.credito.GerenciadorDeCredito;
import com.jands.cafefx.maquinadecafe.model.credito.creditavel.Debito;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

class GerenciadorBebidasTest {

    @Test
    void PrepararBebidaComValorValidoEAguaDisponivel() {
        double creditoAtual = 10;
        double quantidadeDeAguaAtual = 100;
        assertEquals(true, GerenciadorBebidas.prepararBebida(new Capuccino(), creditoAtual, quantidadeDeAguaAtual));
    }

    @Test
    void PrepararBebidaComValorValidoEAguaIndisponivel() {
        double creditoAtual = 10;
        double quantidadeDeAguaAtual = 0;
        try {
            GerenciadorBebidas.prepararBebida(new Capuccino(), creditoAtual, quantidadeDeAguaAtual);
            fail("A Exception não foi Jogada!");
        } catch (ExecutionException e) {
            assertEquals(e, e);
        }
    }

    @Test
    void PrepararBebidaComValorValidoEAguaNegativa() {
        double creditoAtual = 10;
        double quantidadeDeAguaAtual = -10;
        try {
            GerenciadorBebidas.prepararBebida(new Capuccino(), creditoAtual, quantidadeDeAguaAtual);
            fail("A Exception não foi Jogada!");
        } catch (ExecutionException e) {
            assertEquals(e, e);
        }
    }

    @Test
    void PrepararBebidaComValorNegativoEAguaDisponivel() {
        double creditoAtual = -10;
        double quantidadeDeAguaAtual = 100;
        try {
            GerenciadorBebidas.prepararBebida(new Capuccino(), creditoAtual, quantidadeDeAguaAtual);
            fail("A Exception não foi Jogada!");
        } catch (ExecutionException e) {
            assertEquals(e, e);
        }
    }

    @Test
    void PrepararBebidaComValorNegativoEAguaDisponivel() {
        double creditoAtual = -10;
        double quantidadeDeAguaAtual = 100;
        try {
            GerenciadorBebidas.prepararBebida(new Capuccino(), creditoAtual, quantidadeDeAguaAtual);
            fail("A Exception não foi Jogada!");
        } catch (ExecutionException e) {
            assertEquals(e, e);
        }
    }

    @Test
    void PrepararBebidaComValorIgualAPrecoDaBebidaNegativoEAguaDisponivel() {
        IBebida bebida = new Capuccino();
        double creditoAtual = bebida.getPreco();
        double quantidadeDeAguaAtual = 100;
        try {
            GerenciadorBebidas.prepararBebida(bebida, creditoAtual, quantidadeDeAguaAtual);
            fail("A Exception não foi Jogada!");
        } catch (ExecutionException e) {
            assertEquals(e, e);
        }
    }

}