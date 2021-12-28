package com.github.movimentocodar.maquinadecafe.maquinadecafe.reservatorio;

public class CapacidadeReservatorio {
    private double capacidade;

    CapacidadeReservatorio() {
        setCapacidade(1000);
    }

    CapacidadeReservatorio (double capacidadeInicial) {
        setCapacidade(capacidadeInicial);
    }

    private boolean isValid(double capacidade) {
        if (capacidade <= 0) {
            throw new IllegalArgumentException("Capacidade do Reservatorio não pode ser < ou = 0");
        }
        return true;
    }

    public double getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(double capacidade) {
        if (isValid(capacidade)) {
            this.capacidade = capacidade;
        }
    }

}
