package com.jands.cafefx.maquinadecafe.controllerFx.models.bebidas;

import com.jands.cafefx.maquinadecafe.controllerFx.models.componentes.BebidaPreparavel;

public class Capuccino implements BebidaPreparavel, LeiteEmPo {
    SetStatus setStatus = new SetStatus();
    public Capuccino() throws InterruptedException {
        new AguaQuente();
        setStatus.setStatusConsole("Adicionando café em pó...");
        setStatus.setStatusConsole("Adicionando chocolate em pó...");
        adicionarLeite();
    }

    @Override
    public void adicionarLeite() throws InterruptedException {
        new LeiteEmPoModelo().adicionarLeite();
    }
}
