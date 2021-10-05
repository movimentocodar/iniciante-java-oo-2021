package com.jands.cafefx.maquinadecafe.controller.events;

import com.jands.cafefx.maquinadecafe.model.componentes.ReservatorioDeAgua;

public class ReabastecerEvent {
    public static void reabastecerEvent() {
        ReservatorioDeAgua.abastercerAgua();
    }
}
