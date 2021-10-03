package com.jands.cafefx.maquinadecafe.model.bebida;

import com.jands.cafefx.maquinadecafe.model.bebida.processos.FerverAgua;
import com.jands.cafefx.maquinadecafe.model.bebida.processos.Filtro;

public class Processo {

    public static void ferverAgua() throws InterruptedException {
        new FerverAgua().usarProcesso();
    }

    public static void filtrar() throws InterruptedException {
        new Filtro().usarProcesso();
    }


}
