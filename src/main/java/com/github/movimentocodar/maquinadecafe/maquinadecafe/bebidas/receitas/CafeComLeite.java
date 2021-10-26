package com.github.movimentocodar.maquinadecafe.maquinadecafe.bebidas.receitas;

import java.math.BigDecimal;

public class CafeComLeite implements BebidaImpl {
    @Override
    public String nome() {
        return "Café com Leite";
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
        System.out.println("Água Quente + Pó de café + Filtro");
    }

    @Override
    public String toString() {
        return nome();
    }
}
