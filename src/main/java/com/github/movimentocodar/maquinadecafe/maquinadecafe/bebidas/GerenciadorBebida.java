package com.github.movimentocodar.maquinadecafe.maquinadecafe.bebidas;

import com.github.movimentocodar.maquinadecafe.maquinadecafe.bebidas.receitas.BebidaImpl;
import com.github.movimentocodar.maquinadecafe.maquinadecafe.creditos.GerenciadorCredito;
import com.github.movimentocodar.maquinadecafe.maquinadecafe.reservatorio.ReservatorioDeAgua;

import java.math.BigDecimal;

public class GerenciadorBebida {
    public void prepararBebida(BebidaImpl bebida, ReservatorioDeAgua reservatorio, GerenciadorCredito gerenciadorCredito,
                               double qntDeAcucar) {
        if (creditoValido(gerenciadorCredito, bebida) && possuiAgua(reservatorio) ) {
            bebida.preparar();
            if (bebida.isAcucaravel()) {
                adicionarAcucar(qntDeAcucar);
            }
            System.out.println(bebida.nome() + " Finalizado!");
        }
    }

    public void prepararBebida(BebidaImpl bebida, ReservatorioDeAgua reservatorio, GerenciadorCredito gerenciadorCredito) {
        if (creditoValido(gerenciadorCredito, bebida) && possuiAgua(reservatorio)) {
            bebida.preparar();
            if (bebida.isAcucaravel()) {
                adicionarAcucar(3);
            }
            System.out.println(bebida.nome() + " Finalizado!");
        }
    }

    private boolean possuiAgua(ReservatorioDeAgua reservatorio) {
        System.out.println("Reservatorio de agua atual: " + reservatorio.getAguaDoReservatorio());
        if (reservatorio.getAguaDoReservatorio() < 50) {
            throw new IllegalArgumentException("Agua Insuficiente");
        }
        System.out.println("Usando 50ml de Água!");
        reservatorio.usarAgua(50);
        return true;
    }

    private boolean creditoValido(GerenciadorCredito gerenciadorCredito, BebidaImpl bebida) {
        if (gerenciadorCredito.getCreditos().compareTo(BigDecimal.ZERO) < 0 ||
                gerenciadorCredito.getCreditos().compareTo(bebida.preco()) < 0) {
            System.out.println("Credito insuficiente ou invalido!");
            throw new IllegalArgumentException("Credito insuficiente ou invalido!");
        }
        return true;
    }

    private void adicionarAcucar(double qnt) {
        System.out.println("Adicionando " + qnt + " torrões de açúcar");
    }
}
