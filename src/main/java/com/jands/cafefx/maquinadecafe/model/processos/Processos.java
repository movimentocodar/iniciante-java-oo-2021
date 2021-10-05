package com.jands.cafefx.maquinadecafe.model.processos;

import javafx.scene.control.Slider;

public class Processos {

    public static void ferverAgua() {
        new FerverAgua().usarProcesso();
    }

    public static void filtrar() {
        new Filtro().usarProcesso();
    }

    public static void adicionarAcucar(Slider sliderAcucar) throws Exception {
        new AdicionarAcucar().usarProcesso(sliderAcucar);
    }

}
