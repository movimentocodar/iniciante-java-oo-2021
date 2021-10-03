package com.jands.cafefx.maquinadecafe.model.bebida.processos;

import com.jands.cafefx.maquinadecafe.model.componentes.ReservatorioDeAgua;

public class FerverAgua implements IProcessos {
    @Override
    public void usarProcesso() throws InterruptedException {
        System.out.println("Fervendo Agua Espere!");
        ReservatorioDeAgua.usarAgua();
        Thread.sleep(1000);
        System.out.println("Agua Fervida!!!");
    }
}
