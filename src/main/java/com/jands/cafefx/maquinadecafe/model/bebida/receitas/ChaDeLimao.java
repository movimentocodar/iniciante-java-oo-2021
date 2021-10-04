package com.jands.cafefx.maquinadecafe.model.bebida.receitas;

import com.jands.cafefx.maquinadecafe.model.processos.Processos;

public class ChaDeLimao implements IBebida {

    @Override
    public void prepararBebida() {
        new AguaQuente().usarIngrediente();
        new ChaDeLimao().prepararBebida();
        Processos.Filtrar();
        System.out.println("Chá de Limão Pronto!!!");
    }

    @Override
    public boolean isFiltravel() {
        return true;
    }

}
