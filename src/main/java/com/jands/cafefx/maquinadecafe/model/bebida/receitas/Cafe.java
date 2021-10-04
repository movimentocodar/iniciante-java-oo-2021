package com.jands.cafefx.maquinadecafe.model.bebida.receitas;

import com.jands.cafefx.maquinadecafe.model.bebida.receitas.ingredientes.IIngrediente;
import com.jands.cafefx.maquinadecafe.model.bebida.receitas.ingredientes.PoDeCafe;
import com.jands.cafefx.maquinadecafe.model.processos.Processos;

public class Cafe implements IIngrediente, IBebida {

    @Override
    public void prepararBebida() {
        new AguaQuente().usarIngrediente();
        new PoDeCafe().usarIngrediente();
        System.out.println("Café Pronto!!!");
    }

    @Override
    public boolean isFiltravel() {
        return true;
    }

    @Override
    public void usarIngrediente() {
        prepararBebida();
        System.out.println("Adicionando Café");
    }
}
