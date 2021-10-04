package com.jands.cafefx.maquinadecafe.model.credito;

import com.jands.cafefx.maquinadecafe.model.credito.modelocredito.AdicionarCreditoNaMaquina;
import com.jands.cafefx.maquinadecafe.model.credito.creditavel.ICreditavel;
import com.jands.cafefx.maquinadecafe.model.credito.modelocredito.SacarCreditoDaMaquina;

public class GerenciadorDeCredito {
    private static double creditoDaMaquina;

    public static void adicionarCredito(ICreditavel formaDePagamento, double valor) {
        creditoDaMaquina += AdicionarCreditoNaMaquina.adicionar(formaDePagamento, valor);
    }

    public static void sacarCredito(double valor) {
        creditoDaMaquina -= SacarCreditoDaMaquina.sacar(valor, creditoDaMaquina);
    }

    public static double getCreditoDaMaquina() {
        return creditoDaMaquina;
    }
}
