package com.github.movimentocodar.maquinadecafe.maquinadecafe.bebidas.receitas;

import java.math.BigDecimal;

public class Capuccino implements BebidaImpl {
    @Override
    public String nome() {
        return "Capuccino";
    }

    @Override
    public BigDecimal preco() {
        return new BigDecimal("1.50");
    }

    @Override
    public boolean isAcucaravel() {
        return true;
    }

    @Override
    public void preparar() {
        System.out.println("Água Quente + Café em pó + Leite em Pó + Chocolate em Pó + Filtro");
    }

    @Override
    public String toString() {
        return nome();
    }
}
