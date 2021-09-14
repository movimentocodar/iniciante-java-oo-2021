package com.jands.cafefx.maquinadecafe.controllerFx.models.bebidas;

import com.jands.cafefx.maquinadecafe.controllerFx.models.componentes.BebidaPreparavel;

public class SetStatus {
    private String statusConsole;

    public BebidaPreparavel setStatusConsole(String statusConsole) throws InterruptedException {
        this.statusConsole = statusConsole;
        System.out.println(statusConsole);
        Thread.sleep(1500);

        return null;
    }
}
