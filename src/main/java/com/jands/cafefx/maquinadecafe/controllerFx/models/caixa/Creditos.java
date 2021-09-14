package com.jands.cafefx.maquinadecafe.controllerFx.models.caixa;

public interface Creditos {
    boolean descontarValor(double valor);
    void adicionarCreditos(double valor);
    double getCreditos();
}
