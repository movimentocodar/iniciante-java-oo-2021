package com.jands.cafefx.maquinadecafe.controllerFx;

import com.jands.cafefx.maquinadecafe.controllerFx.models.Maquina;
import javafx.scene.control.Label;

public class ReceberTrocoModel {
    public void receberTroco(Maquina maquina, Label labelMyCredits) {
        double creditos = maquina.getCreditos();
        maquina.adicionarCreditos(0);
        labelMyCredits.setText("R$ "+maquina.getCreditos());
        System.out.println("Você recebeu de troco: "+ creditos);
    }
}
