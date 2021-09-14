package com.jands.cafefx.maquinadecafe.controllerFx.models.bebidas;

import com.jands.cafefx.maquinadecafe.controllerFx.models.componentes.BebidaPreparavel;

public class CafeComLeite implements BebidaPreparavel, LeiteEmPo {
    SetStatus setStatus = new SetStatus();
    public CafeComLeite() throws InterruptedException {
        new Cafe();
        adicionarLeite();
        setStatus.setStatusConsole("Café com leite pronto!");
    }

    @Override
    public void adicionarLeite() throws InterruptedException {
        new LeiteEmPoModelo().adicionarLeite();
    }
}
