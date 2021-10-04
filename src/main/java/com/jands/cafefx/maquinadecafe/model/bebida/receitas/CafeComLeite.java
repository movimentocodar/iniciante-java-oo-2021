package com.jands.cafefx.maquinadecafe.model.bebida.receitas;

import com.jands.cafefx.maquinadecafe.model.bebida.receitas.ingredientes.IIngrediente;
import com.jands.cafefx.maquinadecafe.model.bebida.receitas.ingredientes.LeiteEmPo;

public class CafeComLeite implements IBebida {

    @Override
    public void prepararBebida() {
        new Cafe().usarIngrediente();
        new LeiteEmPo().usarIngrediente();
        System.out.println("Café com Leite Pronto!!!");
    }

    @Override
    public boolean isFiltravel() {
        return true;
    }

}
