package com.jands.cafefx.maquinadecafe.model.credito.modelocredito;

public class SubtrairCreditoDaMaquina {

    public static double sacar (double valor, double valorDaMaquina) {
        if (valor < 0 || valor > valorDaMaquina) {
            throw new CreditoInvalidoException("Valor Invalido");
        }
        return valor;
    }

}
