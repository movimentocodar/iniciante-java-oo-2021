package com.jands.cafefx.maquinadecafe.controller;

import com.jands.cafefx.maquinadecafe.controller.events.*;
import com.jands.cafefx.maquinadecafe.model.MaquinaDeCafe;
import com.jands.cafefx.maquinadecafe.model.credito.creditavel.ICreditavel;
import javafx.scene.control.*;

public class ControllerEvents {
    private static SwitchTipoDepositaEvent switchTipoDepositaEvent = new SwitchTipoDepositaEvent();

    public static void SwitchTipoDeposita(Button btnDepositar, ChoiceBox tipoDeposito, ChoiceBox choiceCedulas, TextField creditValue, ICreditavel formaDePagamento) {
        switchTipoDepositaEvent.switchEvent(btnDepositar, tipoDeposito, choiceCedulas, creditValue, formaDePagamento);
    }

    public static void ReceberTrocoEvent(MaquinaDeCafe maquinaDeCafe, Label myCredits) {
        ReceberTrocoEvent.receber(maquinaDeCafe, myCredits);
    }

    public static void DepositarEvent(ChoiceBox tipoDeposito, MaquinaDeCafe maquinaDeCafe, TextField creditValue, ICreditavel debito, Label labelMyCredits, ChoiceBox choiceCedulas) {
        DepositarEvent.depositarEvent(tipoDeposito, maquinaDeCafe, creditValue, debito, labelMyCredits, choiceCedulas);
    }

    public static void PrepararBebidaEvent(MaquinaDeCafe maquinaDeCafe, ChoiceBox bebidasPreparaveis, Label labelMyCredits, Slider sliderAcucar, Label labelStatus) {
        PrepararBebidaEvent.prepararBebidaEvent(maquinaDeCafe, bebidasPreparaveis, labelMyCredits, sliderAcucar, labelStatus);
    }

}
