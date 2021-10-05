package com.jands.cafefx.maquinadecafe.controller.events;

import com.jands.cafefx.maquinadecafe.model.credito.creditavel.ICreditavel;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class SwitchTipoDepositaEvent {
    public void switchEvent(Button btnDepositar, ChoiceBox tipoDeposito, ChoiceBox choiceCedulas, TextField creditValue, ICreditavel debito) {
        if (!btnDepositar.isVisible()) btnDepositar.setVisible(true);

        if (tipoDeposito.getValue().equals(debito)) {
            choiceCedulas.setVisible(false);
            creditValue.setVisible(true);

        } else {
            choiceCedulas.setVisible(true);
            creditValue.setVisible(false);
        }
    }
}

