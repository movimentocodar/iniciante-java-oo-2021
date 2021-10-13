package com.jands.cafefx.maquinadecafe.model.credito.modelocredito;

import com.jands.cafefx.maquinadecafe.model.credito.creditavel.ICreditavel;

public class AdicionarCreditoNaMaquina {

    public static double adicionar(ICreditavel formaDePagamento, double valor) {
        formaDePagamento.isValid(valor);
        return valor;
    }
}
