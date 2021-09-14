package com.jands.cafefx.maquinadecafe.controllerFx.models.componentes;

import javafx.event.ActionEvent;

public interface ReservatorioDeAgua {
    public boolean usarAgua() throws InterruptedException;
    public void abastecerAgua();
}
