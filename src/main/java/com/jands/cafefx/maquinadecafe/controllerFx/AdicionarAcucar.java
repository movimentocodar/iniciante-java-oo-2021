package com.jands.cafefx.maquinadecafe.controllerFx;

import javafx.scene.input.MouseEvent;

public interface AdicionarAcucar {
    void adicionarAcucar(MouseEvent event);
    void checkAcucar(boolean preparar) throws InterruptedException;
}
