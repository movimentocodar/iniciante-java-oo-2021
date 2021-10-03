package com.jands.cafefx.maquinadecafe.model.credito;

import com.jands.cafefx.maquinadecafe.model.credito.modelocredito.AdicionarCreditoNaMaquina;
import com.jands.cafefx.maquinadecafe.model.credito.creditavel.ICreditavel;

public class GerenciadorDeCredito {
    private static double creditoDaMaquina;

    public static void adicionarCredito(ICreditavel formaDePagamento, double valor) {
        AdicionarCreditoNaMaquina.adicionar(formaDePagamento, valor, creditoDaMaquina);
    }

    public static double getCreditoDaMaquina() {
        return creditoDaMaquina;
    }
}
