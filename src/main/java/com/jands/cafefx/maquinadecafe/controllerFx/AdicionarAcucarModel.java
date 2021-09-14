package com.jands.cafefx.maquinadecafe.controllerFx;

import javafx.scene.control.Slider;

public class AdicionarAcucarModel {
    private double acucarValue = 3;
    public void adicionarAcucar(Slider sliderAcucar) {
        if (this.acucarValue!=sliderAcucar.getValue()) {
            this.acucarValue = sliderAcucar.getValue();
            System.out.println("Qnt de açúcar modificada para: "+sliderAcucar.getValue());
        }
    }

    public double getAcucarValue() {
        return this.acucarValue;
    }

    public void checkAcucar(Slider sliderAcucar, boolean bebida) throws InterruptedException {
        if (bebida && !sliderAcucar.isDisabled()) System.out.println("Adicionando quantidade de açúcar: "+ (int) acucarValue);
    }
}
