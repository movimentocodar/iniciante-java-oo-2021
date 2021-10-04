package com.jands.cafefx.maquinadecafe.model.processos;

import com.jands.cafefx.maquinadecafe.model.componentes.ReservatorioDeAgua;

public class FerverAgua implements IProcessos {
    @Override
    public void usarProcesso() {
        try {
            System.out.println("Fervendo Agua Espere!");
            ReservatorioDeAgua.usarAgua();
            Thread.sleep(1000);
            System.out.println("Agua Fervida!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
