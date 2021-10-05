package com.jands.cafefx.maquinadecafe.controller.events;

import com.jands.cafefx.maquinadecafe.model.MaquinaDeCafe;
import com.jands.cafefx.maquinadecafe.model.credito.GerenciadorDeCredito;
import javafx.scene.control.Label;

public class ReceberTrocoEvent {
    public static void receber(MaquinaDeCafe maquinaDeCafe, Label labelMyCredits) {
        maquinaDeCafe.sacarCreditoDaMaquina();
        labelMyCredits.setText(Double.toString(GerenciadorDeCredito.getCreditoDaMaquina()));
    }
}
