package com.github.movimentocodar.maquinadecafe.maquinadecafe;

import com.github.movimentocodar.maquinadecafe.maquinadecafe.bebidas.GerenciadorBebida;
import com.github.movimentocodar.maquinadecafe.maquinadecafe.bebidas.receitas.BebidaImpl;
import com.github.movimentocodar.maquinadecafe.maquinadecafe.creditos.FormaDePagamento;
import com.github.movimentocodar.maquinadecafe.maquinadecafe.creditos.GerenciadorCredito;
import com.github.movimentocodar.maquinadecafe.maquinadecafe.reservatorio.ReservatorioDeAgua;

import java.math.BigDecimal;

public class MaquinaCafe {
    private GerenciadorBebida gerenciadorBebida = new GerenciadorBebida();
    private GerenciadorCredito gerenciadorCredito = new GerenciadorCredito();
    private ReservatorioDeAgua reservatorioDeAgua = new ReservatorioDeAgua();

    public boolean comprarBebida(BebidaImpl bebida) throws Exception {
        gerenciadorBebida.prepararBebida(bebida, reservatorioDeAgua, gerenciadorCredito);
        return true;
    }

    public boolean comprarBebida(BebidaImpl bebida, double qntAcucar) throws Exception {
        gerenciadorBebida.prepararBebida(bebida, reservatorioDeAgua, gerenciadorCredito, qntAcucar);
        return true;
    }

    public boolean adicionarCredito(BigDecimal valor, FormaDePagamento formaDePagamento) {
        gerenciadorCredito.adicionarCredito(valor, formaDePagamento);
        return true;
    }

    public boolean sacarDinheiro(BigDecimal valor) {
        gerenciadorCredito.sacarCredito(valor);
        return true;
    }

    public boolean abastecerMaquina(double valor) {
        reservatorioDeAgua.abastecerReservatorio(valor);
        return true;
    }

    public BigDecimal getCredito() {
        return gerenciadorCredito.getCreditos();
    }
}
