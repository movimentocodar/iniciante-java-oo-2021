package com.jands.cafefx.maquinadecafe.controllerFx;

import com.jands.cafefx.maquinadecafe.controllerFx.models.Maquina;
import com.jands.cafefx.maquinadecafe.controllerFx.models.componentes.Preparar;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

import java.util.ArrayList;

public class PrepararBebidaModel {
    private int selected;

    public boolean prepararBebida(Maquina maquina, int selected, Label labelStatus) throws InterruptedException {
        boolean preparar = maquina.prepararBebida(Preparar.values()[selected]);
        if (preparar) {
            labelStatus.setStyle("-fx-text-fill: green; -fx-font-size: 16;");
            labelStatus.setText("Sucesso!");
        } else {
            labelStatus.setStyle("-fx-text-fill: red; -fx-font-size: 16;");
            labelStatus.setText("Falhou...");
        }
        return preparar;
    }

    public void disableAcucar(ChoiceBox choiceItem, ArrayList items, int selected, Slider sliderAcucar, Label labelValorDaBebida) {
        String value = (String) choiceItem.getValue();
        System.out.println("Você selecionou: "+value);
        this.selected = items.indexOf(value);

        labelValorDaBebida.setText(Preparar.values()[this.selected].titulo() +" custa: R$ "+Preparar.values()[this.selected].getValor());


        if (!value.equals("Água Quente")) {
            sliderAcucar.setDisable(false);
        } else {
            sliderAcucar.setDisable(true);
        }
    }

    public int getSelected() {
        return selected;
    }
}
