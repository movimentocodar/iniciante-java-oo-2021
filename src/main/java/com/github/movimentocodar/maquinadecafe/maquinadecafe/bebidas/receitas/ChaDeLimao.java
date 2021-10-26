package com.github.movimentocodar.maquinadecafe.maquinadecafe.bebidas.receitas;

import java.math.BigDecimal;

public class ChaDeLimao implements BebidaImpl {
    @Override
    public String nome() {
        return "Chá de Limão";
    }

    @Override
    public BigDecimal preco() {
        return new BigDecimal("1.00");
    }

    @Override
    public boolean isAcucaravel() {
        return true;
    }

    @Override
    public void preparar() {
        System.out.println("Água Quente + Chá em pó + Filtro");
    }

    @Override
    public String toString() {
        return nome();
    }
}
