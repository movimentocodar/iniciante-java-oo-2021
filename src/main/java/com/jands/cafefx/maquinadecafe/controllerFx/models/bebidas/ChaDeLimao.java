package com.jands.cafefx.maquinadecafe.controllerFx.models.bebidas;

import com.jands.cafefx.maquinadecafe.controllerFx.models.componentes.BebidaPreparavel;

public class ChaDeLimao implements BebidaPreparavel {
    SetStatus setStatus = new SetStatus();
    public ChaDeLimao() throws InterruptedException {
        new AguaQuente();
        setStatus.setStatusConsole("Adicionando chá em pó...");
    }
}
