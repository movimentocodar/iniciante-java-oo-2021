package com.jands.cafefx.maquinadecafe.model.processos;

import com.jands.cafefx.maquinadecafe.controller.MainController;
import javafx.scene.control.Slider;

public class AdicionarAcucar  {

    public void usarProcesso(Slider sliderAcucar) throws Exception {
        System.out.println("Adicionando quantidade " + sliderAcucar.getValue() + " de Açucar");
    }

}
