package com.github.movimentocodar.maquinadecafe.maquinadecafe.bebidas.receitas;

import java.math.BigDecimal;
import java.util.List;

public class AguaQuente  implements BebidaImpl {
    @Override
    public String nome() {
        return "Água Quente";
    }

    @Override
    public BigDecimal preco() {
        return new BigDecimal("0.00");
    }

    @Override
    public boolean isAcucaravel() {
        return false;
    }

    @Override
    public void preparar() {
        System.out.println("Água do reservatório + Processo para ferver a água");
    }

    @Override
    public String toString() {
        return nome();
    }
}
