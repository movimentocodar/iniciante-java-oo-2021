package com.jands.cafefx.maquinadecafe.model.bebida;

import com.jands.cafefx.maquinadecafe.controllerFx.models.componentes.BebidaPreparavel;
import com.jands.cafefx.maquinadecafe.model.bebida.receitas.IBebida;
import com.jands.cafefx.maquinadecafe.model.processos.Processos;

public class GerenciadorBebidas {

    public static void prepararBebida(IBebida bebida) {
        bebida.prepararBebida();
        if (bebida.isFiltravel()) {
            Processos.Filtrar();
        }
    }

}
