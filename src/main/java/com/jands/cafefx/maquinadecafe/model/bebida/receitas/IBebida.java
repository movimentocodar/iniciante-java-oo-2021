package com.jands.cafefx.maquinadecafe.model.bebida.receitas;

public interface IBebida {

    String getNome();
    void prepararBebida();
    boolean isFiltravel();
    double getPreco();
    boolean isAcucaravel();

}
