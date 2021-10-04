package com.jands.cafefx.maquinadecafe.model.processos;

public class Filtro implements IProcessos {

    @Override
    public void usarProcesso() {
        for (int i = 0; i < 2; i++) {
            try {
                System.out.println("Filtrando.");
                Thread.sleep(500);
                System.out.println("Filtrando..");
                Thread.sleep(500);
                System.out.println("Filtrando...");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Filtrado!");
    }
}
