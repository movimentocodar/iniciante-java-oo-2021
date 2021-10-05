package com.jands.cafefx.maquinadecafe.controller.events;

import com.jands.cafefx.maquinadecafe.model.MaquinaDeCafe;
import com.jands.cafefx.maquinadecafe.model.bebida.receitas.IBebida;
import com.jands.cafefx.maquinadecafe.model.credito.GerenciadorDeCredito;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class PrepararBebidaEvent {
    public static void prepararBebidaEvent(MaquinaDeCafe maquinaDeCafe, ChoiceBox bebidasPreparaveis, Label labelMyCredits, Slider sliderAcucar, Label labelStatus) {
        try {
            if(maquinaDeCafe.prepararBebida((IBebida) bebidasPreparaveis.getValue(), sliderAcucar)) {
                labelMyCredits.setText(Double.toString(GerenciadorDeCredito.getCreditoDaMaquina()));
                labelStatus.setStyle("-fx-text-fill: green; -fx-font-size: 16;");
                labelStatus.setText("Sucesso!");
            } else {
                labelStatus.setStyle("-fx-text-fill: red; -fx-font-size: 16;");
                labelStatus.setText("Falhou...");
            }
        } catch (Exception e) {
            System.out.println("Selecione uma Bebida!!!");
        }
    }
}
