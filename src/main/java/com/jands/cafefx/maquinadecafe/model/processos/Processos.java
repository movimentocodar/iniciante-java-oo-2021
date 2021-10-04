package com.jands.cafefx.maquinadecafe.model.processos;

public class Processos {

    public static void ferverAgua() {
        new FerverAgua().usarProcesso();
    }

    public static void Filtrar() {
        new Filtro().usarProcesso();
    }

}
