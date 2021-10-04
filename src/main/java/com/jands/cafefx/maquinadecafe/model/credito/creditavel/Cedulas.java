package com.jands.cafefx.maquinadecafe.model.credito.creditavel;

import com.jands.cafefx.maquinadecafe.model.credito.modelocredito.AdicionarCreditoNaMaquina;
import com.jands.cafefx.maquinadecafe.model.credito.modelocredito.CreditoInvalidoException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cedulas implements ICreditavel {

    List<Double> celulas = List.of(2.00, 5.00, 10.00, 20.00, 50.00, 100.00, 200.00);

    @Override
    public boolean isValid(double valor) {
        if (!celulas.contains(valor) | valor < 0) {
            throw new CreditoInvalidoException("Valor não é valido");
        }
        return true;
    }

}
