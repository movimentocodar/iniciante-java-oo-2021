package com.jands.cafefx.maquinadecafe.model.processos;

import com.jands.cafefx.maquinadecafe.model.componentes.ReservatorioDeAgua;

public class FerverAgua implements IProcessos {
    @Override
    public void usarProcesso() {
        try {
//            ReservatorioDeAgua.usarAgua();
            System.out.println("Fervendo Agua Espere!");
            Thread.sleep(1000);
            System.out.println("Agua Fervida!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
