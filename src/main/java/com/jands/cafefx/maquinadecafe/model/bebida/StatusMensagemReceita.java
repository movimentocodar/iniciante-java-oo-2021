package com.jands.cafefx.maquinadecafe.model.bebida;

public class StatusMensagemReceita {
    public static void prepararBebida(String ingredinte) {
        System.out.println("Preparando " + ingredinte);
    }

    public static void usarIngrediente(String ingrediente) {
        System.out.println(ingrediente + " Preparado(a) -> Colocando na Bebida");
    }
}
