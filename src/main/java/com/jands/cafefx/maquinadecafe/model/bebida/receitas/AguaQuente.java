package com.jands.cafefx.maquinadecafe.model.bebida.receitas;

import com.jands.cafefx.maquinadecafe.model.bebida.receitas.ingredientes.IIngrediente;
import com.jands.cafefx.maquinadecafe.model.processos.Processos;

public class AguaQuente implements IIngrediente, IBebida {

    @Override
    public void usarIngrediente() {
        prepararBebida();
        System.out.println("Adicionando Agua Quente");
    }

    @Override
    public void prepararBebida() {
        Processos.ferverAgua();
        System.out.println("Agua Quente Pronta!!!");
    }

    @Override
    public boolean isFiltravel() {
        return false;
    }
}
