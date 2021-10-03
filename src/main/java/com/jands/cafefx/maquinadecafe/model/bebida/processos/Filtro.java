package com.jands.cafefx.maquinadecafe.model.bebida.processos;

public class Filtro implements IProcessos {

    @Override
    public void usarProcesso() throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            System.out.println("Filtrando.");
            Thread.sleep(500);
            System.out.println("Filtrando..");
            Thread.sleep(500);
            System.out.println("Filtrando...");
            Thread.sleep(500);
        }
        System.out.println("Filtrado!");
    }
}
