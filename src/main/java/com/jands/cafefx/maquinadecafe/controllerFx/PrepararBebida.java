package com.jands.cafefx.maquinadecafe.controllerFx;

import javafx.event.ActionEvent;

public interface PrepararBebida {
    void prepararBebida(ActionEvent event) throws InterruptedException;
    void disableAcucar(ActionEvent event);
}
