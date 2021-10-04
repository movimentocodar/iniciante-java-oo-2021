package com.jands.cafefx.maquinadecafe.model.credito.modelocredito;

import com.jands.cafefx.maquinadecafe.model.credito.creditavel.ICreditavel;

public class AdicionarCreditoNaMaquina {

    public static double adicionar(ICreditavel formaDePagamento, double valor) {
        if (!formaDePagamento.isValid(valor)){
            throw new CreditoInvalidoException("Forma de pagamento não é valida");
        }
        return valor;
    }
}
