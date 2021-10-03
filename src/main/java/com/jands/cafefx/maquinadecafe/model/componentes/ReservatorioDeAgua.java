package com.jands.cafefx.maquinadecafe.model.componentes;

public class ReservatorioDeAgua {
    private static double agua = 1000.00;

    public static void usarAgua() {
        agua -= 50;
    }

}
