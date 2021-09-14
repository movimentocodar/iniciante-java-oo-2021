package com.jands.cafefx.maquinadecafe.controllerFx.models.bebidas;

import com.jands.cafefx.maquinadecafe.controllerFx.models.componentes.BebidaPreparavel;

public class Cafe implements BebidaPreparavel {
    SetStatus setStatus = new SetStatus();
    public Cafe() throws InterruptedException {
        new AguaQuente();
        setStatus.setStatusConsole("Adicionando pó de café...");
        setStatus.setStatusConsole("Café pronto!");
    }

}
