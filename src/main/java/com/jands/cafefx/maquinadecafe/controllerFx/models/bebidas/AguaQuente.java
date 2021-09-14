package com.jands.cafefx.maquinadecafe.controllerFx.models.bebidas;


import com.jands.cafefx.maquinadecafe.controllerFx.models.componentes.BebidaPreparavel;

public class AguaQuente implements BebidaPreparavel {
    SetStatus setStatus = new SetStatus();

    public AguaQuente() throws InterruptedException {
        ferverAgua();
        setStatus.setStatusConsole("Água quente pronta!");

    }
    public void ferverAgua() throws InterruptedException {
        setStatus.setStatusConsole("Fervendo água...");
    }
}
