package com.jands.cafefx.maquinadecafe.model.credito.modelocredito;

import com.jands.cafefx.maquinadecafe.model.credito.creditavel.ICreditavel;

public class AdicionarCreditoNaMaquina {

    public static boolean adicionar(ICreditavel formaDePagamento, double valor, double creditoAtualDaMaquina) {
        if (formaDePagamento.isValid(valor)){
            return formaDePagamento.adicionarCredito(valor);
        }
    }
}
