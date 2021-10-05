package com.jands.cafefx.maquinadecafe.controller.events;

import com.jands.cafefx.maquinadecafe.model.MaquinaDeCafe;
import com.jands.cafefx.maquinadecafe.model.credito.GerenciadorDeCredito;
import com.jands.cafefx.maquinadecafe.model.credito.creditavel.ICreditavel;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DepositarEvent {
    public static void depositarEvent(ChoiceBox tipoDeposito, MaquinaDeCafe maquinaDeCafe, TextField creditValue, ICreditavel debito, Label labelMyCredits, ChoiceBox choiceCedulas) {
        try {
            if (tipoDeposito.getValue().equals(debito)) {
                maquinaDeCafe.adicionarCreditoNaMaquina((ICreditavel) tipoDeposito.getValue(), Double.parseDouble(creditValue.getText()));
                labelMyCredits.setText(Double.toString(GerenciadorDeCredito.getCreditoDaMaquina()));
            } else {
                maquinaDeCafe.adicionarCreditoNaMaquina((ICreditavel) tipoDeposito.getValue(), (Double) choiceCedulas.getValue());
                labelMyCredits.setText(Double.toString(GerenciadorDeCredito.getCreditoDaMaquina()));
            }
        } catch (Exception e) {
            System.out.println("Valor Invalido!!!");
        }
    }
}
